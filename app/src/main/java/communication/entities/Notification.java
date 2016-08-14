package communication.entities;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *通知Java类
 */
public class Notification implements Jsonable{

    private String id;
    private String title;
    private String content;
    private Date publiishDate;
    private String sender;
    private List receivers;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubliishDate() {
        return publiishDate;
    }

    public void setPubliishDate(Date publiishDate) {
        this.publiishDate = publiishDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List getReceivers() {
        return receivers;
    }

    public void setReceivers(List receivers) {
        this.receivers = receivers;
    }

    private Map getMap(){
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("id",id);
        map.put("title",title);
        map.put("content",content);
        map.put("publishDate",publiishDate);
        map.put("sender",sender);
        map.put("receivers",receivers);
        return map;
    }

    @Override
    public String toString(){
        return "notification";
    }

    @Override
    public JSONObject toJson(Object object) {
        return new JSONObject(this.getMap());
    }

    /**
     * 将JSON数据转化为Java对象
     */
    public static Object readFromJson(String json){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JsonError","Not JSONObject");
        }
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
}
