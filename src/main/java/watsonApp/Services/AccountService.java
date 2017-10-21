package watsonApp.Services;

import org.springframework.stereotype.Service;
import watsonApp.Beans.*;
import java.util.ArrayList;
import java.util.Date;
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
    private ArrayList<String> dummy;

    public AccountService(){
        dummy = new ArrayList<>();
    }

    public Client getClient(String clientId){
        return clients.stream().filter(c -> c.getClientId().equals(clientId)).findFirst().get();
    }

    public Account getAccount(int accountId){
        return accounts.stream().filter(a ->  a.getAccountId() == accountId).findFirst().get();
    }

    public Account getAccount(String iban){
        return accounts.stream().filter(a ->  a.getIban().equals(iban)).findFirst().get();
    }

    public List getAccounts(Client client){
        return accounts.stream().filter(a -> a.getClient().equals(client)).collect(Collectors.toList());
    }

    public Transaction getTransaction(int transactionId){
        return transactions.stream().filter(t -> t.getTransactionId() == transactionId).findFirst().get();
    }

    public List getTransactions(Client client, Account account, String otherAccount, String infoOtherAccount,
                                double amount1, double amount2, Date date1, Date date2, String communication){
        return null;//transactions.stream().filter().collect(Collectors.toList());
    }

    public void append(String str){
        dummy.add(str);
    }

    public ArrayList<String> getDummy() {
        return dummy;
    }

    public String hello(){
        return "Hello";
    }
}
