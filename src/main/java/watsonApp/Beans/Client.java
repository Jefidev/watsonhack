package watsonApp.Beans;

public class Client {

    private String clientId;
    private String lastname;
    private String firstname;
    private Account account;

    public Client(String clientId, String lastname, String firstname) {
        this.clientId = clientId;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
