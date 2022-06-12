package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTest {

    @Test
    @DisplayName("Deposit should increase balance when positive amount")
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){

        double amount = 200.00;
        double expectedValue = 196.00;

        Account account = AccountFactory.createEmptyAccount();

        account.deposit(amount);

        Assertions.assertEquals(expectedValue , account.getBalance());

    }

    @Test
    @DisplayName("Deposit should do nothing when negative amount")
    public void depositShouldDoNothingWhenNegativeAmount(){

        double expectedValue = 100.00;
        Account account = AccountFactory.createAccount(expectedValue);
        double amount = -200.00;

        account.deposit(amount);

        Assertions.assertEquals(expectedValue, account.getBalance());
    }

    @Test
    @DisplayName("Withdraw should decrease balance when sufficient balance")
    public void withDrawShoulDecreaseBalanceWhenSufficientBalance(){

        Account account =  AccountFactory.createAccount(800.00);

        account.withDraw(500.00);

        Assertions.assertEquals(300.00 , account.getBalance());

    }

    @Test
    @DisplayName("Withdraw chould ThrowIllegalArgumentException when balance insufficient balance")
    public void withDrawShouldThrowIllegalArgumentExceptionWhenBalanceInsufficientBalance(){

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Account account = AccountFactory.createAccount(100.00);
            account.withDraw(200.00);
        });
    }

    @Test
    @DisplayName("Full withdraw should clear balance and return full balance")
    public void fullWithDrawShouldClearBalanceAndReturnFullBalance(){

        double expectedValue = 0.0;
        double initialBalance = 800.00;
        Account account = AccountFactory.createAccount(initialBalance);

        double result = account.fullWithDraw();


        Assertions.assertEquals(expectedValue , account.getBalance());
        Assertions.assertEquals(result , initialBalance);
    }
}
