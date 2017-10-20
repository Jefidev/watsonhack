package watsonApp.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jfink on 20/10/17.
 */

@RestController
public class DummyController {

    @RequestMapping("/")
    public String hello(){
        return "Hello";
    }
}
