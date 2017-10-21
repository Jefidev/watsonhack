package watsonApp.Entities;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import java.lang.reflect.Executable;

/**
 * Created by jfink on 21/10/17.
 */
public class MessageContainer {

    private String text;
    private String domain;
    private String[] placeHolder;
    private String check;
    private JSONObject jsonObject;
    private String type;
    private String container;



    public MessageContainer(JSONObject json){
        type ="default";

        JSONObject output = json.getJSONObject("output");
        jsonObject=json;


        JSONArray array = output.getJSONArray("text");
        text=array.getString(0).toString();




        try{
            domain=output.getString("domain");}
        catch (Exception e){}

        try{
            check=output.getString("check");}
        catch (Exception e){}

        try {
            array = output.getJSONArray("placeHolder");
            placeHolder=new String[array.length()];
            for (int i = 0; i < array.length(); i++) {
                placeHolder[i]=array.getString(i);
            }
            type="placeHolder";
        }
        catch (Exception e){}

        try{
            container=output.getString("container");}
        catch (Exception e){}



    }

    public String getContainer() {
        return container;
    }


    public String getType() {
        return type;
    }


    public String getDomain() {
        return domain;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }


    public String[] getPlaceHolder() {
        return placeHolder;
    }

    public String getCheck() {
        return check;
    }

    public String getText() {
        return text;
    }



}
