package watsonApp.Beans;

public class Transactions {

    private int transactionId;
    private Account account;
    private String otherAccount;
    private String infoOtherAccount;
    private boolean from; /* = true if it's the other account who execute the transaction, else false.*/
    private double amount;
    private String communication;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {

        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getOtherAccount() {
        return otherAccount;
    }

    public void setOtherAccount(String otherAccount) {
        this.otherAccount = otherAccount;
    }

    public String getInfoOtherAccount() {

        return infoOtherAccount;
    }

    public void setInfoOtherAccount(String infoOtherAccount) {
        this.infoOtherAccount = infoOtherAccount;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isFrom() {

        return from;
    }

    public void setFrom(boolean from) {
        this.from = from;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

}
