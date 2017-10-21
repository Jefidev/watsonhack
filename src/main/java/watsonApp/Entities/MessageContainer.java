package watsonApp.Entities;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by jfink on 21/10/17.
 */
public class MessageContainer {

    private String text;
    private String domain;
    private String placeHolder;
    private String accountNumber;



    public MessageContainer(JSONObject json){
        JSONObject output = json.getJSONObject("output");
        JSONArray array = output.getJSONArray("text");

        text=array.toString();


    }
}
