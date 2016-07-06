package communication;

import java.util.HashMap;
import java.util.Map;

/**
 * 阅读情况Java类
 */
public class ReadStatus {

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

    public Map getMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sid",sid);
        map.put("nid",nid);
        map.put("read",read);
        map.put("star",star);
        return map;
    }
    @Override
    public String toString(){
        return "read_status";
    }
}
