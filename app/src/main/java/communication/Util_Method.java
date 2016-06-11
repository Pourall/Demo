package communication;

import android.os.Handler;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;

/**
 * 为外部提供接收数据与发送数据的API
 */
public class Util_Method {

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


    /**
     * 将Java对象转换为JSON对象
     */
    public static JSONObject toJSON(Object object){
        JSONObject json = null;
        if(object.toString().equals("notification")){
            Notification notification =(Notification)object;
            json = new JSONObject(notification.getMap());
        }
        if(object.toString().equals("student")){
            Student student = (Student)object;
            json = new JSONObject(student.getMap());
        }
        if(object.toString().equals("read_status")){
            Read_Status read_status = (Read_Status)object;
            json = new JSONObject(read_status.getMap());
        }
        return  json;
    }
    /**
     * 将JSON数据转化为Java对象
     */
    public static Object toJavaObject(String json,String type){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JsonError","Not JSONObject");
        }
        if(type.equals("notification")){
            Notification notification =new Notification();
            try {
                notification.setId((String) jsonObject.get("id"));
                notification.setTitle((String) jsonObject.get("title"));
                notification.setContent((String) jsonObject.get("content"));
                notification.setPubliishDate((Date) jsonObject.get("publishDate"));
                notification.setSender((String) jsonObject.get("sender"));
                notification.setReceivers((List) jsonObject.get("receiver"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return notification;
        }
        if(type.equals("student")){
            Student student = new Student();
            try {
                student.setId((String) jsonObject.get("id"));
                student.setCharacter((String) jsonObject.get("character"));
                student.setName((String) jsonObject.get("name"));
                student.setPassword((String) jsonObject.get("password"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return student;
        }
        if(type.equals("read_status")){

        }
        return null;
    }
}
