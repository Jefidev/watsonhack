package watsonApp.Controllers;

import com.github.messenger4j.send.buttons.Button;
import com.github.messenger4j.send.templates.ButtonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import watsonApp.Beans.Account;
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
    private AccountService accountService;

    @RequestMapping("/")
    public String hello(){
        return accountService.hello() + "11";
    }

    @RequestMapping("/database")
    public List<Account> data(){

        List<Account> accList = accountService.getAccounts(accountService.getClient("1476584332431836"));
        Button.ListBuilder b = Button.newListBuilder();

        for(Account a :accList){
            b.addPostbackButton("account "+ a.getAccountId(), a.getAccountId()).toList();
        }

        final ButtonTemplate buttonTemplate = ButtonTemplate.newBuilder("ouifsjhfdsjbsjhfbsjhbfjshdbfhsbd", b.build()).build();
        return accountService.getAccounts(accountService.getClient("1476584332431836"));
    }

}
