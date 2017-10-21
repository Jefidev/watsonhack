package watsonApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import watsonApp.Entities.MessageContainer;
import watsonApp.Services.AccountService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jfink on 20/10/17.
 */

@RestController
public class DummyController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/")
    public String hello(){
        return accountService.hello();
    }
    
}
