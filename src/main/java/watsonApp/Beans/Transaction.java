package watsonApp.Beans;

import java.util.Date;

public class Transaction{

    private String transactionId;
    private Account account;
    private String otherAccount;
    private String infoOtherAccount;
    private boolean from; /* = true if it's the other account who execute the transaction, else false.*/
    private double amount;
    private Date date;
    private String communication;

    public Transaction(String transactionId, Account account, String otherAccount, String infoOtherAccount, boolean from,
                        double amount, Date date){
        this.transactionId = transactionId;
        this.account = account;
        this.otherAccount = otherAccount;
        this.infoOtherAccount = infoOtherAccount;
        this.from = from;
        this.amount = amount;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

}
