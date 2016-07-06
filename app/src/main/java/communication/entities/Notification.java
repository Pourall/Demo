package communication.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *通知Java类
 */
public class Notification {

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

    public Map getMap(){
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
}
