import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BMRCalculatorTest {


    @org.junit.Test
    @DisplayName("Test Case [BMRCalculatorTest]")
    public  void BMRCalculatorTest() {
        User user = new User("John","Cena",'M',98,6,24);
       double expectedBMI = 902.5;
       double actualBMR = BMRCalculator.BMRCalc(user);
        Assertions.assertEquals(expectedBMI, actualBMR);
        System.out.println("Expected Outcome : " + expectedBMI);
        System.out.println("Actual   Outcome : " + actualBMR);
        System.out.println("Test Successful");

    }

}