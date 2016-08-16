package communication;

import android.os.Handler;
import communication.entities.*;

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
        ThreadManager.start(Config.SERVER_ADDR+"users/"+"2014220101001"+"/notifications/","GET",null,handler);
    }

}
