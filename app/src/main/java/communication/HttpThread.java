package communication;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;


/**
 * 与服务器通信的线程
 */
public class HttpThread implements Runnable{

    private String url;
    private String method;
    private Handler handler;
    private Map jsonMap;

    /**
     * 构造方法中传入四个参数，分别是服务器地址，提交方法，要传递的JSON Map，
     * handler（返回收到的信息将在handler的handle message方法中收到）
     */
    public HttpThread(String url, String method, Map jsonMap, Handler handler){
        this.url = url;
        this.method = method;
        this.handler = handler;
        this.jsonMap = jsonMap;
    }
    /* *
     * 线程run方法
     * */
    @Override
    public void run() {
        Message message = getHttpMessage(method);
        handler.sendMessage(message);
    }
    /* *
     * 从服务器获取反馈信息及数据储存在Message中
     * */
    private Message getHttpMessage(String method){
        Message message = null;
        HttpURLConnection urlConnection = InitHttpConnection();
        if(method.equals("GET")){
            message = Get(urlConnection);
        }else if(method.equals("POST")){

        }
        return  message;
    }


    private HttpURLConnection InitHttpConnection(){
        URL httpurl = null;
        HttpURLConnection urlConnection = null;
        //http连接
        try {
            httpurl = new URL(url);
            urlConnection = (HttpURLConnection) httpurl.openConnection();
            String authEncoded = getAuthorizationBasicString(Config.SERVER_USER,Config.SERVER_PASSWORD);
            urlConnection.setRequestProperty("Authorization", "Basic "+authEncoded);
            urlConnection.setRequestMethod(method);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(urlConnection !=null){
                urlConnection.disconnect();
            }
        }
        return urlConnection;
    }
    /* *
     * Get authorization basic string
     * */
    private String getAuthorizationBasicString(String user,String password){
        String authStr =user+":"+password;
        // encode data  using BASE64
        byte[] bytesEncoded = Base64.encode(authStr .getBytes(),Base64.DEFAULT);
        String authEncoded = new String(bytesEncoded);
        return authEncoded;
    }
    /* *
    * http get方法提交请求
    * */
    private Message Get(HttpURLConnection urlConnection){
        Message message = Message.obtain();

        StringBuffer sb =new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String str;
            while((str=reader.readLine())!=null){
                sb.append(str);
            }
            message.obj = sb.toString();
            message.arg1 = urlConnection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

}
