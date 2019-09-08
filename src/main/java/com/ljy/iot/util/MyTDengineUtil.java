package com.ljy.iot.util;

import net.sf.cglib.beans.BeanMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ljy.iot.util.TDengineUtil.getFieldNameBySetter;

/**
 * @author : 夕
 * @date : 2019/9/4
 */
public class MyTDengineUtil {

    private static Logger logger = LoggerFactory.getLogger(MyTDengineUtil.class);

    private static final String TSDB_DRIVER = "com.taosdata.jdbc.TSDBDriver";

    //加载驱动
    static {
        try {
            Class.forName(TSDB_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private  Connection connection;
    //是否开启数据库列名下划线转驼峰
    private boolean databaseColumnHumpToLine;


    public MyTDengineUtil(){

    }

    public MyTDengineUtil(String jdbcUrl, boolean databaseColumnHumpToLine) throws SQLException {
        this.connection = DriverManager.getConnection(jdbcUrl);
        this.databaseColumnHumpToLine = databaseColumnHumpToLine;
    }

    public <T> T getOne(String sql, Class<T> clazz) throws SQLException, InstantiationException, IllegalAccessException {
        Method[] setMethods = getSetMethods(clazz);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);

        resultSet.next();
        return resultSetToObject(resultSet,setMethods,clazz);
    }

    public <T> List<T> getList(String sql, Class<T> clazz) throws SQLException, InstantiationException, IllegalAccessException {

        List<T> list = new ArrayList<>();
        Method[] setterMethods = getSetMethods(clazz);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);

        while (resultSet.next())
        {
            list.add(resultSetToObject(resultSet, setterMethods, clazz));
        }
        return list;

    }

    public boolean insert(String tableName,Object o) throws SQLException {

        Class clazz = o.getClass();
        Map<String,Object> map = BeanMap.create(o);
        String sql = createInsertSql(tableName,map);
        return connection.createStatement().execute(sql);

    }

    public static String createInsertSql(String tableName,Map<String,Object> map) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("INSERT INTO ").append(tableName).append(" (");

        Set<Map.Entry<String,Object>> set = map.entrySet();

        StringBuilder keys = new StringBuilder(" ");
        StringBuilder value = new StringBuilder(" ");

        for (Map.Entry<String,Object> entry : set){
            keys.append(humpToLine(entry.getKey())).append(",");
            try {
                if (entry.getValue().getClass().equals(Date.class)){
                    Date d = (Date)entry.getValue();
                    value.append(d.getTime()).append(",");
                }
                else {
                    value.append("'").append(entry.getValue()).append("'").append(",");
                }
            }
            catch (Exception ignored) {

            }
        }

        keys.deleteCharAt(keys.length()-1);
        value.deleteCharAt(value.length()-1);

        buffer.append(keys).append(") VALUES( ").append(value).append(")");
        buffer.append(";");
        System.out.println( buffer.toString());
        return buffer.toString();
    }

    public <T> T resultSetToObject(ResultSet resultSet, Method[] setterMethods, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T result;
        try
        {
            result = clazz.newInstance();
        }
        catch (InstantiationException e)
        {
            System.out.println("请检查类" + clazz.getCanonicalName() + "是否有无参构造方法");
            throw e;
        }


        for (Method method : setterMethods)
        {
            try
            {
                String fieldName = getFieldNameBySetter(method);

                //因为标准的setter方法只会有一个参数，所以取一个就行了
                Class getParamClass = method.getParameterTypes()[0];



                //获得查询的结果
                Object resultObject;

                //是否启用驼峰转下划线规则获得数据库字段名
                if (databaseColumnHumpToLine)
                {
                    resultObject = resultSet.getObject(humpToLine(fieldName));
                }
                else
                {
                    resultObject = resultSet.getObject(fieldName);
                }

                //如果实体类的类型是String类型，那么无论x数据库类型是什么，都调用其toString方法获取值
                if (getParamClass.equals(String.class))
                {
                    method.invoke(result, resultObject.toString());
                }
                else if (getParamClass.equals(Date.class) && resultObject.getClass().equals(Long.class))
                {
                    method.invoke(result, new Date((Long) resultObject));
                }
                else
                {
                    try
                    {
                        method.invoke(result, resultObject);
                    }
                    catch (IllegalArgumentException e)
                    {
                        //对象字段与数据库类型(通过jdbc读取到的)不一致的情况下，将尝试强制转型
                        method.invoke(result, getParamClass.cast(resultObject));
                    }
                }
            }
            catch (Exception ignored)
            {
                //所有的转型都失败了，则使用默认值
            }
        }

        return result;
    }

    public static String getFieldNameBySetMethod(Method method){
        return toLowerCaseFirstOne(method.getName().substring(3));
    }

    /**
     * 首字母转小写
     */
    public static String toLowerCaseFirstOne(String s)
    {
        if (Character.isLowerCase(s.charAt(0)))
        {
            return s;
        }
        else
        {
            return Character.toLowerCase(s.charAt(0)) + s.substring(1);
        }
    }

    public static Method[] getSetMethods(Class clazz){
        Method[] methods = clazz.getMethods();
        Method[] setMethods = new Method[methods.length/2];

        int i = 0;
        for (Method m : methods){
            if(m.getName().startsWith("set")){
                setMethods[i] = m;
                i++;
            }
        }
        return setMethods;
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    /**
     * 驼峰转下划线
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
