import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;

public class ExerciseDatabase {
	public static String readExercise(String exerciseType, String exercise) {
		String output = "";
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String sql = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
		ResultSet rs = null;
		Statement state = null;

		try {
			Scanner sc = new Scanner(databasePassword);
			while (sc.hasNextLine()) {
				password = sc.nextLine();
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("Could not read root password");
		}

		try {
			Connection con = DriverManager.getConnection(url, sql, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {

			String command = "SELECT * FROM " + exerciseType + ";";
			rs = state.executeQuery(command);
		} catch (Exception e) {
			System.out.println("Could not retreive user data from table");
		}
		try {
			for (int i = 1; i < 6; i++) {
				String temp = rs.getNString(i);
				if(temp.equals(exercise)) {
					return temp;
				}
			}
		} catch (Exception e) {
			System.out.println("An error occurred");
		}
		

		return null;
	}
}
