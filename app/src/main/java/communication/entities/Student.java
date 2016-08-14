package communication.entities;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 学生Java类
 */
public class Student implements Jsonable{

    private String id;

    private String name;

    private String character;

    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    private Map getMap(){
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("id",id);
        map.put("name",name);
        map.put("character",character);
        return map;
    }

    @Override
    public JSONObject toJson(Object object) { return new JSONObject(this.getMap());}

    @Override
    public String toString(){
        return "student";
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

}
