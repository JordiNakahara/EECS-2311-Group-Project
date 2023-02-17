import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {

    private User user;

    @Before
    public void runBeforeEach() {
        user = new User();
    }

    @org.junit.Test
    @DisplayName("Test Case [Set User Name]")
    public void setFirstNameTest() {
        String setName = "John";
        user.setFName(setName);
        Assertions.assertEquals(setName, user.getFName());
        System.out.println("Expected Outcome : " + setName);
        System.out.println("Actual   Outcome : " + user.getFName());
        System.out.println("Test Successful");

    }

    @org.junit.Test
    @DisplayName("Test Case [Get User Name]")
    public void getFirstNameTest() {
        String getName = "John";
        user.setFName(getName);
        Assertions.assertEquals(getName, user.getFName());
        System.out.println("Expected Outcome : " + getName);
        System.out.println("Actual   Outcome : " + user.getFName());
        System.out.println("Test Successful");

    }

    @org.junit.Test
    @DisplayName("Test Case [Set Last Name]")
    public void setLastNameTest() {
        String setLastName = "Cena";
        user.setLName(setLastName);
        Assertions.assertEquals(setLastName, user.getLName());
        System.out.println("Expected Outcome : " + setLastName);
        System.out.println("Actual   Outcome : " + user.getLName());
        System.out.println("Test Successful");

    }

    @org.junit.Test
    @DisplayName("Test Case [Set Last Name]")
    public void getLastNameTest() {
        String getLastName = "Cena";
        user.setLName(getLastName);
        Assertions.assertEquals(getLastName, user.getLName());
        System.out.println("Expected Outcome : " + getLastName);
        System.out.println("Actual   Outcome : " + user.getLName());
        System.out.println("Test Successful");

    }

    @org.junit.Test
    @DisplayName("Test Case [setGenderTest]")
    public void setGenderTest() {
        char setGender = 'M';
        user.setGender(setGender);
        Assertions.assertEquals(setGender, user.getGender());
        System.out.println("Expected Outcome : " + setGender);
        System.out.println("Actual   Outcome : " + user.getGender());
        System.out.println("Test Successful");

    }

    @org.junit.Test
    @DisplayName("Test Case [getGenderTest")
    public void getGenderTest() {
        char getGender = 'M';
        user.setGender(getGender);
        Assertions.assertEquals(getGender, user.getGender());
        System.out.println("Expected Outcome : " + getGender);
        System.out.println("Actual   Outcome : " + user.getGender());
        System.out.println("Test Successful");

    }


    @org.junit.Test
    @DisplayName("Test Case [setWeightTest]")
    public void setWeightTest() {
        double setWeight = 98.5;
        user.setWeight(setWeight);
        Assertions.assertEquals(setWeight, user.getWeight());
        System.out.println("Expected Outcome : " + setWeight);
        System.out.println("Actual   Outcome : " + user.getWeight());
        System.out.println("Test Successful");

    }

    @org.junit.Test
    @DisplayName("Test Case [getWeightTest]")
    public void getWeightTest() {
        double getWeight = 98.5;
        user.setWeight(getWeight);
        Assertions.assertEquals(getWeight, user.getWeight());
        System.out.println("Expected Outcome : " + getWeight);
        System.out.println("Actual   Outcome : " + user.getWeight());
        System.out.println("Test Successful");

    }

    @org.junit.Test
    @DisplayName("Test Case [setHeightTest]")
    public void setHeightTest() {
        double setHeight = 5.11;
        user.setHeight(setHeight);
        Assertions.assertEquals(setHeight, user.getHeight());
        System.out.println("Expected Outcome : " + setHeight);
        System.out.println("Actual   Outcome : " + user.getHeight());
        System.out.println("Test Successful");

    }

    @org.junit.Test
    @DisplayName("Test Case [getHeightTest]")
    public void getHeightTest() {
        double getHeight = 5.11;
        user.setHeight(getHeight);
        Assertions.assertEquals(getHeight, user.getHeight());
        System.out.println("Expected Outcome : " + getHeight);
        System.out.println("Actual   Outcome : " + user.getHeight());
        System.out.println("Test Successful");

    }

    @org.junit.Test
    @DisplayName("Test Case [setAge]")
    public void setAgeTest() {
        int setAge = 24;
        user.setAge(setAge);
        Assertions.assertEquals(setAge, user.getAge());
        System.out.println("Expected Outcome : " + setAge);
        System.out.println("Actual   Outcome : " + user.getAge());
        System.out.println("Test Successful");

    }


    @org.junit.Test
    @DisplayName("Test Case [getAgeTest]")
    public void getAgeTest() {
        int getAge = 24;
        user.setAge(getAge);
        Assertions.assertEquals(getAge, user.getAge());
        System.out.println("Expected Outcome : " + getAge);
        System.out.println("Actual   Outcome : " + user.getAge());
        System.out.println("Test Successful");

    }

    @org.junit.Test
    @DisplayName("Test Case [getBMR]")
    public void getBMRTest() {
        user = new User("John","Cena",'M',98,6,24);
         double expectedBMR = 902.5;
        Assertions.assertEquals(expectedBMR, user.getBMR());
        System.out.println("Expected Outcome : " + expectedBMR);
        System.out.println("Actual   Outcome : " + user.getBMR());
        System.out.println("Test Successful");

    }



}
