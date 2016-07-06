package communication;

import android.os.Handler;

import org.json.JSONObject;


import java.io.IOException;
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
    public HttpTread(String url,String method,JSONObject jsonobj,Handler handler){
        this.url = url;
        this.method = method;
        this.handler = handler;
        this.jsonobj = jsonobj;
    }
    /**
     * 待完善的http连接
     * */
    @Override
    public void run() {
        URL httpurl = null;
        HttpURLConnection urlConnection = null;
        try {
            httpurl = new URL(url);
            urlConnection = (HttpURLConnection) httpurl.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(urlConnection !=null){
                urlConnection.disconnect();
            }
        }

    }


}
