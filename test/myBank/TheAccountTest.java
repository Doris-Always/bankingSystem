package myBank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TheAccountTest {

    private  MyAccount account;

    @BeforeEach
    public void setUp(){
       account = new MyAccount("Doris Ebele","1","1244");
    }

    @Test
    @DisplayName("Test That Account can Be created")
    public void testThatAccountCanBeCreated(){
        //given that account exists: already at BeforeEach
        //check that account exist
        //check that my balance is zero
        assertNotEquals(null,account);
        assertEquals(0,account.getBalance("1233"));
    }

    @Test
    @DisplayName("Test That I can Deposit Money Into My Account my money increases")
    public void testThatICanDepositMoneyInMyAccount(){
        //given that i have an account
        //when my balance is zero
        //when i deposit 500
        //check that balance becomes 500
        assertEquals(0,account.getBalance("1233"));
        account.deposit(500);
        assertEquals(500,account.getBalance("1233"));
    }

    @Test
    public void testThatIcannotDepositNegativeMoney(){
        //given that i have an account
        //when i deposit -500
        //check that balance remains the same
        assertEquals(0,account.getBalance("1233"));
        account.deposit(-500);
        assertEquals(0,account.getBalance("1233"));
    }

    @Test
    @DisplayName("Test That I cannot Check Account Balance With the right pin")
    public void testThatICanCheckMyBalanceWithTheRightPin(){
        //given that i have an account
        //i have 500 in my account
        //when i check my account balance with 1244
        //check that it returns my balance
        assertEquals(0,account.getBalance("1244"));
        account.deposit(500);
        assertEquals(500,account.getBalance("1244"));

    }

    @Test
    @DisplayName("Test That I Can Withdraw With The Right Pin And Not Above My Balance")
    public void testThatIcanWithdrawWithTheRightpinAndNotAboveMyBalance(){
        //given that i have an accont
        //i deposited 1000
        //when i withdraw 500 with a pin of 1244
        //my balance will be 500
        account.deposit(1000);
        account.withdraw(500,"1244");
        assertEquals(500,account.getBalance("1244"));

    }
}
