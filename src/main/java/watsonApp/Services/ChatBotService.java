package watsonApp.Services;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import org.springframework.stereotype.Service;

/**
 * Created by jfink on 20/10/17.
 */

@Service
public class ChatBotService {

    private Conversation chatbot;

    public ChatBotService(){
        chatbot = new Conversation(Conversation.VERSION_DATE_2016_07_11);
        chatbot.setUsernameAndPassword("2731ab1f-148e-4802-949d-b016c34ccbf3","P4K6TzWNvZWB");
    }

    public String getChatbotResponse (String message){
        InputData input = new InputData.Builder(message).build();
        MessageOptions options = new MessageOptions.Builder().input(input).build();
        MessageResponse response = chatbot.message(options).execute();
        return response.toString();
    }

}
