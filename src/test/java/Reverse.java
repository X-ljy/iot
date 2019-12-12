import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;

class Reverse{

    public static void main(String[] args) {

        HashMap map = new HashMap<Integer,Integer>();
        map.put(1,2);
        int a = (int) map.get(1);
        a++;
        map.put(1,a);
        System.out.println(map.get(1));

    }
}