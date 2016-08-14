package communication;

import android.os.Handler;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;

import communication.entities.*;
import communication.ThreadManager;
import communication.Config;
/**
 * 为外部提供接收数据与发送数据的API
 */
public class UtilMethods {

    /**
     * handleMessage方法将会收到两个参数，arg1将是HTTP状态码，
     * obj将是获得的Java对象，通过覆写的toString方法获知Java对象的类型标识
     * */

    /**
     * 发送新通知,反馈信息将在主线程中的handler的handle message方法中得到;
     */
    public static void send_new_notification(Notification notification,Handler handler){

    }

    /**
     * 获取所有通知,通知的反馈信息将在主线程中的handler的handle message方法中得到;
     */
    public static void get_all_notification(Handler handler){
        ThreadManager.start(Config.SERVER_ADDR+"/users/"+Config.SID+"/notification/","GET",null,handler);
    }

}
