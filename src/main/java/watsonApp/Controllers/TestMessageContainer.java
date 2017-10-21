package watsonApp.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestMessageContainer {

    @RequestMapping("/francois")
    public String test(){
        return "coucou";
    }
}
