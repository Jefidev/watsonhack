package watsonApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import watsonApp.Services.ChatBotService;

@RestController
public class TestMessageContainer {

    @Autowired
    ChatBotService chatBotService;

    @RequestMapping("/francois")
    public String test(){
        chatBotService.getChatbotResponse("Yeah");

        return "coucou";
    }
}
