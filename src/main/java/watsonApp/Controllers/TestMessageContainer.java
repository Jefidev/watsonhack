package watsonApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import watsonApp.Entities.MessageContainer;
import watsonApp.Services.ChatBotService;

@RestController
public class TestMessageContainer {

    @Autowired
    ChatBotService chatBotService;

    @RequestMapping("/francois")
    public String test(){
        MessageContainer messageContainer=chatBotService.getChatbotResponse("balance account 1");

        return messageContainer.getText();
    }

    @RequestMapping("/domain")
    public String domain(){
        MessageContainer messageContainer=chatBotService.getChatbotResponse("balance account 1");

        return messageContainer.getDomain();
    }

    @RequestMapping("/json")
    public String testJson(){
        MessageContainer messageContainer=chatBotService.getChatbotResponse("balance account 1");

        return messageContainer.getJsonObject().toString();
    }

    @RequestMapping("/placeHolder")
    public String placeHolder(){
        MessageContainer messageContainer=chatBotService.getChatbotResponse("balance account 1");
        String[] s = messageContainer.getPlaceHolder();
        System.out.println(s);
        System.out.print("test");
        return s[0];
    }

    @RequestMapping("/type")
    public String type(){
        MessageContainer messageContainer=chatBotService.getChatbotResponse("balance account 1");

        return messageContainer.getType().toString();
    }
}
