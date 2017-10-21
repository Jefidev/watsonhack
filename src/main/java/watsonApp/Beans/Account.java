package watsonApp.Beans;

public class Account {

    private String accountId;
    private String iban;
    private double balance;
    private Client client;

    public Account(String accountId, String iban, double balance, Client client){
        this.accountId = accountId;
        this.iban = iban;
        this.balance = balance;
        this.client = client;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
