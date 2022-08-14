package myBank;

public class MyAccount {

    private int balance;
    private String accountName;
    private String accountNumber;
    private String pin;

    public MyAccount(String accountName,String pin,String accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    public int getBalance(String pin) {
        if (this.pin.equals(pin))return balance;

        return 0;
    }

    public int deposit(int amount) {
        var validAmount = amount > 0;
        if (validAmount) {
            balance+=amount;
        }
        return balance;
    }

    public void withdraw(int amount, String pin) {
        if (this.pin.equals(pin) && amount < getBalance(pin)){
            balance = balance - amount;
        }

    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getAccountName(){
        return accountName;
    }
}
