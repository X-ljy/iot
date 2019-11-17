package tdengine;

import okhttp3.*;
import okio.BufferedSink;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * @author : 夕
 * @date : 2019/11/17
 */
public class RestfulTD {

    //Base64 编码，用户认证编码
    final static Base64.Encoder encoder = Base64.getEncoder();

    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(30, TimeUnit.SECONDS).build();

    public static String getTdData(String host,String port,String user,String password,String sql) throws IOException {

        //构建RequestBody
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"),sql);

        //构建Request
        Request request = new Request.Builder()
                .url("http://" + host + ":" + port + "/rest/sql")
                .post(requestBody)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Basic " + encoder.encodeToString((user + ":" + password).getBytes()))
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", host + ":" + port)
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Connection", "keep-alive")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = okHttpClient.newCall(request).execute();

        return response.body().string();
    }

    public static void main(String[] args) throws IOException {

        System.out.println(getTdData("49.235.215.208","6020","root","taosdata","select * from iot.t_iot_sun5015  where ts >= \"2019-11-17 13:55:03\""));

    }

}
