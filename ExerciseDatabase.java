import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//Class for reading exercise data from database
public class ExerciseDatabase {
	public static String readExercise(String exerciseType, String exercise) {
		
		//Variable initialization
		String output = "";
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String sql = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
		ResultSet rs = null;
		Statement state = null;
		
		//Read root password to login
		try {
			Scanner sc = new Scanner(databasePassword);
			while (sc.hasNextLine()) {
				password = sc.nextLine();
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("Could not read root password");
		}
		
		//Create connection to database
		try {
			Connection con = DriverManager.getConnection(url, sql, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}
		
		//Read the user data from the table
		try {

			String command = "SELECT * FROM " + exerciseType + ";";
			rs = state.executeQuery(command);
		} catch (Exception e) {
			System.out.println("Could not retreive exercise data from table");
		}
		try {
			int counter = 1;
			while (counter < 5) {
				rs.next();
				String result = rs.getString("name");
				if(result.equals(exercise)) {
					return rs.getString("name");
				}
				counter ++;
				
			}
			
			/*for (int i = 1; i < 6; i++) {
				String temp = rs.getNString(i);
				if (temp.equals(exercise)) {
					return temp;
				}
			}*/
		} catch (Exception e) {
			System.out.println("An error occurred");
			System.out.println(e.getMessage());
		}

		return null;
	}
}
