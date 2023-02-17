import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserDatabaseTest {
    private User user;

    @Before
    @DisplayName("Test Case [runBeforeEach]")
    public void runBeforeEach() {
        user = new User("John", "Cena", 'M', 98, 6.0, 24);
    }

    @Test
    @DisplayName("Test Case [writeUserToFileTest]")
    public void writeUserToFileTest() {
        UserDatabase.writeUserToFile(user);
        String expectedResult = "\n" + "FirstName:John\n" +
                "LastName:Cena\n" +
                "Gender:M\n" +
                "Weight:98.0\n" +
                "Height:6.0\n" +
                "Age:24\n" +
                "BMR:902.5";
        Assertions.assertEquals(expectedResult, UserDatabase.readUserFile());
        System.out.println("=====================================");
        System.out.println("Expected Outcome : " + expectedResult);
        System.out.println("=======================================\n");
        System.out.println("Actual   Outcome : " + UserDatabase.readUserFile());
        System.out.println("Test Successful");
    }

    @Test
    @DisplayName("Test Case [readUserFileTest]")
    public void readUserFileTest() {
        UserDatabase.writeUserToFile(user);
        String expectedResult = "\n" + "FirstName:John\n" +
                "LastName:Cena\n" +
                "Gender:M\n" +
                "Weight:98.0\n" +
                "Height:6.0\n" +
                "Age:24\n" +
                "BMR:902.5";
        Assertions.assertEquals(expectedResult, UserDatabase.readUserFile());
        System.out.println("=====================================");
        System.out.println("Expected Outcome : " + expectedResult);
        System.out.println("=======================================\n");
        System.out.println("Actual   Outcome : " + UserDatabase.readUserFile());
        System.out.println("Test Successful");
    }

    @Test
    @DisplayName("Test Case [readFirstNameTest]")
    public void readFirstNameTest() {
        UserDatabase.writeUserToFile(user);
        String expectedResult = "John" ;
        Assertions.assertEquals(expectedResult, UserDatabase.readFirstName());
        System.out.println("=====================================");
        System.out.println("Expected Outcome : " + expectedResult);
        System.out.println("=======================================");
        System.out.println("Actual   Outcome : " + UserDatabase.readFirstName());
        System.out.println("\nTest Successful");
    }

    @Test
    @DisplayName("Test Case [readLastNameTest]")
    public void readLastNameTest() {
        UserDatabase.writeUserToFile(user);
        String expectedResult = "Cena" ;
        Assertions.assertEquals(expectedResult, UserDatabase.readLastName());
        System.out.println("=====================================");
        System.out.println("Expected Outcome : " + expectedResult);
        System.out.println("=======================================");
        System.out.println("Actual   Outcome : " + UserDatabase.readLastName());
        System.out.println("\nTest Successful");
    }

    @Test
    @DisplayName("Test Case [readGenderTest]")
    public void readGenderTest() {
        UserDatabase.writeUserToFile(user);
        char expectedResult = 'M' ;
        Assertions.assertEquals(expectedResult, UserDatabase.readGender());
        System.out.println("=====================================");
        System.out.println("Expected Outcome : " + expectedResult);
        System.out.println("=======================================");
        System.out.println("Actual   Outcome : " + UserDatabase.readGender());
        System.out.println("\nTest Successful");
    }

    @Test
    @DisplayName("Test Case [readWeightTest]")
    public void readWeightTest() {
        UserDatabase.writeUserToFile(user);
        double expectedResult = 98 ;
        Assertions.assertEquals(expectedResult, UserDatabase.readWeight());
        System.out.println("=====================================");
        System.out.println("Expected Outcome : " + expectedResult);
        System.out.println("=======================================");
        System.out.println("Actual   Outcome : " + UserDatabase.readWeight());
        System.out.println("\nTest Successful");
    }

    @Test
    @DisplayName("Test Case [readHeightTest]")
    public void readHeightTest() {
        UserDatabase.writeUserToFile(user);
        double expectedResult = 6.0;
        Assertions.assertEquals(expectedResult, UserDatabase.readHeight());
        System.out.println("=====================================");
        System.out.println("Expected Outcome : " + expectedResult);
        System.out.println("=======================================");
        System.out.println("Actual   Outcome : " + UserDatabase.readHeight());
        System.out.println("\nTest Successful");
    }

    @Test
    @DisplayName("Test Case [readAgeTest]")
    public void readAgeTest() {
        UserDatabase.writeUserToFile(user);
        int expectedResult = 24;
        Assertions.assertEquals(expectedResult, UserDatabase.readAge());
        System.out.println("=====================================");
        System.out.println("Expected Outcome : " + expectedResult);
        System.out.println("=======================================");
        System.out.println("Actual   Outcome : " + UserDatabase.readAge());
        System.out.println("\nTest Successful");
    }
}
