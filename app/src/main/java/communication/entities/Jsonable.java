    package communication.entities;

import org.json.JSONObject;

/**
 * Created by fan on 2016/8/13.
 */
public interface Jsonable {
    /**
     * 将Java对象转化为Json
     **/
    public JSONObject toJson(Object object);
}
