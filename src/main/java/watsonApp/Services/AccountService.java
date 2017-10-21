package watsonApp.Services;

import org.springframework.stereotype.Service;
import watsonApp.Beans.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jfink on 20/10/17.
 */

@Service
public class AccountService {

    private ArrayList<Client> clients;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public AccountService(){
        clients = new ArrayList<>();
        Client jerome = new Client("1476584332431836", "Fink", "Jérôme");
        clients.add(jerome);
        Client francois = new Client("1611773255535751", "Georis", "François");
        clients.add(francois);
        Client sophie = new Client("1200422176725563", "Fortz", "Sophie");
        clients.add(sophie);
        Client simon = new Client("1536245626442975", "Genin", "Simon");
        clients.add(simon);

        accounts = new ArrayList<>();
        Account a1 = new Account("1230 0000 0000 0000 1 N1", "BE36 7777 5555 5555",40.04, jerome);
        Account a2 = new Account("1236 0000 0000 0000 1 N1", "BE36 2222 5555 5555",6739, jerome);
        Account b1 = new Account("7880 0000 0000 0000 1 N1", "BE36 3333 5555 5555",13.6, sophie);
        Account b2 = new Account("7894 0000 0000 0000 1 N1", "BE36 8888 5555 5555",2431.03, sophie);
        Account c1 = new Account("5612 0000 0000 0000 1 N1", "BE36 5555 5555 5555",4.32, simon);
        Account c2 = new Account("5614 0000 0000 0000 1 N1", "BE36 4444 5555 5555",11323.99, simon);
        Account c3 = new Account("5616 0000 0000 0000 1 N1", "BE36 6666 5555 5555",89.2, simon);
        Account d1 = new Account("1599 0000 0000 0000 1 N1", "BE36 9999 5555 5555",250.11, francois);
        Account d2 = new Account("1597 0000 0000 0000 1 N1", "BE36 1111 5555 5555",2.5, francois);
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(b1);
        accounts.add(b2);
        accounts.add(c1);
        accounts.add(c2);
        accounts.add(c3);
        accounts.add(d1);
        accounts.add(d2);

        LocalDateTime date1 = LocalDateTime.of(2017, 5,17,14,32);
        LocalDateTime date2 = LocalDateTime.of(2017, 10,5,14,44);
        LocalDateTime date3 = LocalDateTime.of(2017, 10,12,16,32);
        LocalDateTime date4 = LocalDateTime.of(2017, 6,5,22,52);
        LocalDateTime date5 = LocalDateTime.of(2017, 9,13,55,32);
        LocalDateTime date6 = LocalDateTime.of(2017, 9,5,14,59);
        LocalDateTime date7 = LocalDateTime.of(2017, 9,31,134,32);
        LocalDateTime date8 = LocalDateTime.of(2017, 8,15,14,21);
        LocalDateTime date9 = LocalDateTime.of(2017, 7,5,14,1);
        LocalDateTime date10 = LocalDateTime.of(2017, 8,25,12,32);
        LocalDateTime date11 = LocalDateTime.of(2017, 7,5,14,32);

        transactions = new ArrayList<>();
        transactions.add(new Transaction("a", a2, "BE36 4444 5555 5555",
                "Simon Genin",false, 25.3, date1));
        transactions.add(new Transaction("b", c2, "BE36 7777 5555 5555",
                "Jérôme Fink",true, 25.3, date1));
        transactions.add(new Transaction("c", a2, "BE36 4444 5555 3333",
                "Burger King",false, 13.99, date1));
        transactions.add(new Transaction("d", a2, "BE36 7777 5555 1111",
                "Colruyt Namur",false, 45.69, date1));
        transactions.add(new Transaction("e", a1, "BE36 9999 5555 5555",
                "François Georis",true, 12.3, date1));
        transactions.add(new Transaction("f", d1, "BE36 7777 5555 5555",
                "Jérôme Fink",false, 12.3, date1));

    }

    public Client getClient(String clientId){
        return clients.stream().filter(c -> c.getClientId().equals(clientId)).findFirst().get();
    }

    public Account getAccount(String accountId){
        return accounts.stream().filter(a ->  a.getAccountId().equals(accountId)).findFirst().get();
    }

    public Account getAccountByIban(String iban){
        return accounts.stream().filter(a ->  a.getIban().equals(iban)).findFirst().get();
    }

    public List<Account> getAccounts(Client client){
        return accounts.stream().filter(a -> a.getClient().equals(client)).collect(Collectors.toList());
    }

    public Transaction getTransaction(String transactionId){
        return transactions.stream().filter(t -> t.getTransactionId().equals(transactionId)).findFirst().get();
    }

    public List<Transaction> getTransactions(Client client, Account account, String otherAccount, String infoOtherAccount,
                                double amount1, double amount2, LocalDateTime date1, LocalDateTime date2, String communication){
        return null;//transactions.stream().filter().collect(Collectors.toList());
    }

    public String hello(){
        return "Hello";
    }
}
