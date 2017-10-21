package watsonApp.Services;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import watsonApp.Entities.MessageContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jfink on 20/10/17.
 */

@Service
public class ChatBotService {

    private Conversation chatbot;
    private final String workSpaceID = "09d2e181-d3ea-4980-a3d9-ab0d554bfd59";

    private HashMap<String, Context> contextMap;

    public ChatBotService(){
        contextMap = new HashMap<>();
        chatbot = new Conversation(Conversation.VERSION_DATE_2016_07_11);
        chatbot.setUsernameAndPassword("2731ab1f-148e-4802-949d-b016c34ccbf3","P4K6TzWNvZWB");
        chatbot.setEndPoint("https://gateway.watsonplatform.net/conversation/api");
    }

    public MessageContainer getChatbotResponse (String message, String id){

        Context context = contextMap.get(id);

        InputData input = new InputData.Builder(message).build();
        MessageOptions options = new MessageOptions.Builder(workSpaceID).input(input).context(context).build();
        MessageResponse response = chatbot.message(options).execute();

        context = response.getContext();
        contextMap.put(id, context);
        JSONObject json = new JSONObject(response.toString());

        return new MessageContainer(json);
    }

    public String render(String template, List<String> values) {
        int size = values.size();

        for (int i = 0 ; i < size ; i++) {
            template = template.replace("&"+Integer.toString(i)+"&", values.get(i));
        }
        return template;
    }

}
