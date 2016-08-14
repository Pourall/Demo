package communication.entities;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 阅读情况Java类
 */
public class ReadStatus implements Jsonable{

    private String sid;
    private String nid;
    private Boolean read;
    private Boolean star;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Boolean getStar() {
        return star;
    }

    public void setStar(Boolean star) {
        this.star = star;
    }

    private Map getMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sid",sid);
        map.put("nid",nid);
        map.put("read",read);
        map.put("star",star);
        return map;
    }
    @Override
    public String toString(){ return "readstatus"; }

    @Override
    public JSONObject toJson(Object object) { return new JSONObject(this.getMap());}

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
        ReadStatus readStatus = new ReadStatus();
        try {
            readStatus.setNid((String)jsonObject.get("nid"));
            readStatus.setRead((boolean)jsonObject.get("rid"));
            readStatus.setSid((String)jsonObject.get("sid"));
            readStatus.setStar((boolean)jsonObject.get("star"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return readStatus;
    }

}
