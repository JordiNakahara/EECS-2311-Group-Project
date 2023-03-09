import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.sql.*;

public class UserDatabase {

	public static void writeUserToFile(User user) {

		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String sql = "root";
		String password = "";
		File databasePassword = new File ("rootinfo.txt");
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
			String command = "insert into userdata (first_name, last_name, gender, weight, height, age, bmr) values (" + user.getFName() + ", " +user.getLName() + ", " + user.getGender() + ", " + user.getWeight() + ", " + user.getHeight() + ", " + user.getBMR() + ");";

			   state.executeQuery(command);
		} catch (Exception e) {
			System.out.println("Could not add user data to table");
		}




	}

	public static String readUserFile() {

		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File ("rootinfo.txt");
		String output = "";
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
			Connection con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {
			
			String command = "SELECT * FROM userdata;";
			ResultSet rs = state.executeQuery(command);

			output = "First name: " + rs.getString("first_name") + "\n" + "Last name: " + rs.getString("last_name") + "\n" +"Gender: " + rs.getString("gender") + "\n" + "Weight: "  + rs.getString("weight") + "\n" + "Height: " + rs.getString("height") + "\n" + "Age: " + rs.getString("age") + "\n" + "BMR: "
				 + rs.getString("bmr") + "\n";
		} catch (Exception e) {
			System.out.println("Could not retreive user data from table");
		}
		
		return output;
	}

	public static String readFirstName() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File ("rootinfo.txt");
		String output = "";
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
			Connection con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {
			
			String command = "SELECT * FROM userdata;";
			ResultSet rs = state.executeQuery(command);

			output = rs.getString("first_name");
		} catch (Exception e) {
			System.out.println("Could not retreive user data from table");
		}

		return output;
	}

	public static String readLastName() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File ("rootinfo.txt");
		String output = "";
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
			Connection con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {
			
			String command = "SELECT * FROM userdata;";
			ResultSet rs = state.executeQuery(command);

			output = rs.getString("last_name");
		} catch (Exception e) {
			System.out.println("Could not retreive user data from table");
		}

		return output;
	}

	public static char readGender() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File ("rootinfo.txt");
		String temp = "";
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
			Connection con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {
			
			String command = "SELECT * FROM userdata;";
			ResultSet rs = state.executeQuery(command);

			temp = rs.getString("gender");
		} catch (Exception e) {
			System.out.println("Could not retreive user data from table");
		}

		return temp.charAt(0);
	}

	public static double readWeight() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File ("rootinfo.txt");
		String output = "";
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
			Connection con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {
			
			String command = "SELECT * FROM userdata;";
			ResultSet rs = state.executeQuery(command);

			output = rs.getString("weight");
		} catch (Exception e) {
			System.out.println("Could not retreive user data from table");
		}

		return Double.parseDouble(output);
	}

	public static double readHeight() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File ("rootinfo.txt");
		String output = "";
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
			Connection con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {
			
			String command = "SELECT * FROM userdata;";
			ResultSet rs = state.executeQuery(command);

			output = rs.getString("height");
		} catch (Exception e) {
			System.out.println("Could not retreive user data from table");
		}

		return Double.parseDouble(output);

	}

	public static int readAge() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File ("rootinfo.txt");
		String output = "";
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
			Connection con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {
			
			String command = "SELECT * FROM userdata;";
			ResultSet rs = state.executeQuery(command);

			output = rs.getString("age");
		} catch (Exception e) {
			System.out.println("Could not retreive user data from table");
		}

		return Integer.parseInt(output);
	}

	public static double readBMR() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File ("rootinfo.txt");
		String output = "";
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
			Connection con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {
			
			String command = "SELECT * FROM userdata;";
			ResultSet rs = state.executeQuery(command);

			output = rs.getString("bmr");
		} catch (Exception e) {
			System.out.println("Could not retreive user data from table");
		}

		return Double.parseDouble(output);
	}

}
