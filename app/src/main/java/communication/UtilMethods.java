package communication;

import android.os.Handler;
import android.os.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 为外部提供接收数据与发送数据的API
 */

public class UtilMethods {
    /**
     * 与User有关的方法
     */
    public static class User{
        private static Handler handler;
        /**
         * 当接收
         */
        public static void get_all_notifications(Handler handler0){
            handler = handler0;
            final Handler handler1 = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    Message message = Message.obtain();
                    message.arg1 = msg.arg1;

                    List<Map> list = new ArrayList();
                    JSONArray jsonArray = null;

                    try {
                        jsonArray = new JSONArray((String)msg.obj);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if(jsonArray!=null){
                        try {
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Map<String,Object> map = new HashMap();

                                map.put("id",jsonObject.get("id"));
                                map.put("title",jsonObject.get("title"));
                                map.put("content",jsonObject.get("content"));
                                map.put("publishDate",jsonObject.get("publishDate"));

                                JSONObject jsonObject1 = jsonObject.getJSONObject("sender");
                                Map<String,String> map1 = new HashMap();
                                map1.put("id",(String)jsonObject1.get("id"));
                                map1.put("name",(String)jsonObject1.get("name"));
                                map1.put("character",(String)jsonObject1.get("character"));

                                map.put("sender",map1);

                                list.add(map);
                            }
                            message.obj = list;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    handler.sendMessage(message);
                }
            };
            ThreadManager.start(Config.SERVER_ADDR+"users/"+"2014220101001"+"/notifications/","GET",null,handler1);
        }
        public static void send_new_notification(Map map ,Handler handler){

        }
    }

}
