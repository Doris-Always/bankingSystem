package myBank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    Bank firstBank;

    @BeforeEach
    public void setUp(){
       firstBank = new Bank();
    }

    @Test
    public void testThatBankExist(){
        //given that bank exist
        //check that bank exist
        assertNotEquals(null,firstBank);
    }

    @Test
    public void testThatICanOpenAnAccount(){
        //given that bank exist
        //when i create an account with the bank
        //check that the account exist
        firstBank.createAnAccountFor("Doris Ebele","1234","1");
        firstBank.createAnAccountFor("Ben Ned","1244","2");
        assertEquals(2,firstBank.getListOfCustomer());


    }

    @Test
    public void testThatICanCreateAccount_FindAccountByAccountNumber(){
        //given that i have an account
        //when i create account with name,pin and number
        //check that i can find account using account number
        firstBank.createAnAccountFor("Doris Ebele","1234","1");
        firstBank.createAnAccountFor("Ben Ned","1244","2");
        assertEquals(2,firstBank.getListOfCustomer());
        MyAccount account = firstBank.findAnAccountFor("2");
        assertEquals("Ben Ned",account.getAccountName());

    }

    @Test
    public  void testThatACustomerCanDepositMoney(){
        //given that i have an account with first bank
        //when i deposit money into my account
        //my own account balance increases
        firstBank.createAnAccountFor("Doris Ebele","1234","1");
         firstBank.deposit(2000,"1");
    }

    @Test
    public void testThatACustomerCanCheckBalance(){
        //given that i have an account with first bank
        //when i deposit money 2000
        //when i check my account balance,it returns 2000
        firstBank.createAnAccountFor("Doris Ebele","1234","1");
        firstBank.deposit(2000,"1");
        MyAccount account = firstBank.findAnAccountFor("1");
        assertEquals(2000,account.getBalance("1234"));
    }

    @Test
    public void testThatACustomerCan_WithdrawFromAccount(){
        //given that i have an account with first bank
        //when i deposit money 2000
        //check that i can withdraw 1000 and balance will be 1000
        firstBank.createAnAccountFor("Doris Ebele","1234","1");
        firstBank.deposit(2000,"1");
        MyAccount account = firstBank.findAnAccountFor("1");
        firstBank.withdraw(1000,"1","1234");
        assertEquals(1000,account.getBalance("1234"));
    }
}
