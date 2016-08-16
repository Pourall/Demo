package communication;

import android.os.Handler;
import android.util.Base64;

import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;;
import java.net.URL;


/**
 * 与服务器通信的线程
 */
public class HttpThread implements Runnable{

    private String url;
    private String method;
    private Handler handler;
    private JSONObject jsonobj;

    /**
     * 构造方法中传入四个参数，分别是服务器地址，提交方法，要传递的JSON对象，
     * handler（返回状态码和收到的信息将在handler的handle message方法中收到）
     */
    public HttpThread(String url, String method, JSONObject jsonobj, Handler handler){
        this.url = url;
        this.method = method;
        this.handler = handler;
        this.jsonobj = jsonobj;
    }
    /**
     * http连接
     * */
    @Override
    public void run() {
        URL httpurl = null;
        HttpURLConnection urlConnection = null;
        try {
            httpurl = new URL(url);
            String authStr =Config.SERVER_USER+":"+Config.SERVER_PASSWORD;
            // encode data  using BASE64
            byte[] bytesEncoded = Base64.encode(authStr .getBytes(),Base64.DEFAULT);
            String authEncoded = new String(bytesEncoded);
            urlConnection = (HttpURLConnection) httpurl.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic "+authEncoded);

            urlConnection.setRequestMethod(method);

            StringBuffer sb =new StringBuffer();
            BufferedReader reader =new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String str;
            while((str=reader.readLine())!=null){
                sb.append(str);
            }
            System.out.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(urlConnection !=null){
                urlConnection.disconnect();
            }
        }
    }


}
