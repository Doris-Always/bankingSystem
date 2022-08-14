package myBank;

public class Bank {

    private String accountNumber;
    private String accountName;
    private String pin;
    private int listOfCustomer;
    MyAccount [] accounts = new MyAccount[10];


    public void createAnAccountFor(String accountName, String pin, String accountNumber) {
        MyAccount account = new MyAccount(accountName,pin, (listOfCustomer + 1)+"");
        accounts[listOfCustomer] = account;
        listOfCustomer++;
    }

    public int getListOfCustomer() {
        return listOfCustomer;
    }

    public MyAccount findAnAccountFor(String accountNumber) {
        for (MyAccount account : accounts){
            if (account.getAccountNumber().equals(accountNumber))
                return account;
        }

        return null;
    }

    public void deposit(int amount, String accountNumber) {
        MyAccount account = findAnAccountFor(accountNumber);
        account.deposit(amount);

    }


    public void withdraw(int amount, String accountNumber, String pin) {
        MyAccount account = findAnAccountFor(accountNumber);
        account.withdraw(amount,pin);
    }
}
