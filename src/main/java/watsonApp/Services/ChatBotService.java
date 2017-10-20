package watsonApp.Services;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jfink on 20/10/17.
 */

@Service
public class ChatBotService {

    private Conversation chatbot;
    private final String workSpaceID = "09d2e181-d3ea-4980-a3d9-ab0d554bfd59";
    private Context context = null;

    public ChatBotService(){
        chatbot = new Conversation(Conversation.VERSION_DATE_2016_07_11);
        chatbot.setUsernameAndPassword("2731ab1f-148e-4802-949d-b016c34ccbf3","P4K6TzWNvZWB");
        chatbot.setEndPoint("https://gateway.watsonplatform.net/conversation/api");
    }

    public String getChatbotResponse (String message){
        InputData input = new InputData.Builder(message).build();
        MessageOptions options = new MessageOptions.Builder(workSpaceID).input(input).context(context).build();
        MessageResponse response = chatbot.message(options).execute();

        JSONObject json = new JSONObject(response.toString());
        JSONObject output = json.getJSONObject("output");
        JSONArray array = output.getJSONArray("text");

        return array.getString(0);
    }

}
