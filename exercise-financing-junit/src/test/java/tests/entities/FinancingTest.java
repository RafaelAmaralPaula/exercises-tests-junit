package tests.entities;

import entities.Financing;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FinancingTest {

    @Test
    @DisplayName("Constructor should create object when valid data")
    public void constructorShouldCreateObjectWhenValidData(){
        Financing financing = new Financing(100000.00 , 2000.00 , 80);

        Assertions.assertEquals(100000.00 , financing.getTotalAmount());
        Assertions.assertEquals(2000.00 , financing.getIncome());
        Assertions.assertEquals(80 , financing.getMonths());

    }

    @Test
    @DisplayName("Constructor should ThrowIllegalArgumentException when invalid data")
    public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData(){
        Assertions.assertThrows(IllegalArgumentException.class , () ->{
            Financing financing =  new Financing(100000.00 , 2000.00 , 20);
        });

    }

    @Test
    @DisplayName("SetTotalAmount should set data when valid data")
    public void setTotalAmountShouldUSetDataWhenValidData(){
        Financing financing = new Financing(100000.00 , 2000.00 , 80);
        financing.setTotalAmount(90000.0);


        Assertions.assertEquals(90000.0,financing.getTotalAmount());

    }

    @Test
    @DisplayName("SetTotalAmount should ThrowIllegalArgumentException when invalid data")
    public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData(){
        Assertions.assertThrows(IllegalArgumentException.class , ()->{
           Financing financing = new Financing(100000.00 , 2000.00 , 80);
           financing.setTotalAmount(1100000.0);
        });
    }

    @Test
    @DisplayName("SetIncome should set data when valid data")
    public void setIncomeShouldUSetDataWhenValidData(){
        Financing financing = new Financing(100000.00 , 2000.00 , 80);
        financing.setIncome(4000.00);


        Assertions.assertEquals(4000.0,financing.getIncome());

    }

    @Test
    @DisplayName("SetIncome should ThrowIllegalArgumentException when invalid data")
    public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData(){
        Assertions.assertThrows(IllegalArgumentException.class , ()->{
            Financing financing = new Financing(100000.00 , 2000.00 , 80);
            financing.setIncome(900.00);
        });
    }

    @Test
    @DisplayName("SetMonths should set data when valid data")
    public void setMonthsShouldUSetDataWhenValidData(){
        Financing financing = new Financing(100000.00 , 2000.00 , 80);
        financing.setMonths(100);


        Assertions.assertEquals(100,financing.getMonths());

    }
    @Test
    @DisplayName("SetMonths should ThrowIllegalArgumentException when invalid data")
    public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData(){
        Assertions.assertThrows(IllegalArgumentException.class , ()->{
            Financing financing = new Financing(100000.00 , 2000.00 , 80);
            financing.setMonths(10);
        });
    }

    @Test
    @DisplayName("Entry should calculate entry correctly")
    public void entryShouldCalculateEntryCorrectly(){
        Financing financing = new Financing(100000.00 , 2000.00 , 80);

        Assertions.assertEquals(20000.00 , financing.entry());
    }

    @Test
    @DisplayName("Quota should calculate quota correctly")
    public void quotaShouldCalculateQuotaCorrectly(){
        Financing financing = new Financing(100000.00 , 2000.00 , 80);

       Assertions.assertEquals(1000.00 , financing.quota());
    }

}
