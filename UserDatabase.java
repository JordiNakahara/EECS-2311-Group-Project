import java.io.File;
import java.util.Scanner;
import java.sql.*;

//Class to read and write user information to database
public class UserDatabase {
	
	//Writes user information to file given a User object
	public static void writeUserToFile(User user) {

		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String sql = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
		Statement state = null;
		Connection con = null;

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
			con = DriverManager.getConnection(url, sql, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {
			String command = "insert into userdata values ('"
					+ user.getFName() + "', '" + user.getLName() + "', '" + user.getGender() + "', " + user.getWeight()
					+ ", " + user.getHeight() + ", " + user.getAge() + ", " + user.getBMR() + ");";

			state.executeUpdate(command);
		} catch (Exception e) {
			System.out.println("Could not add user data to table");
			System.out.println(e.getMessage());

		}

	}
	
	//Reads all the user info from the database
	public static String readUserFile() {

		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
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
			System.out.println(command);
			ResultSet rs = state.executeQuery(command);

			output = "First name: " + rs.getString("first_name") + "\n" + "Last name: " + rs.getString("last_name")
					+ "\n" + "Gender: " + rs.getString("gender") + "\n" + "Weight: " + rs.getString("weight") + "\n"
					+ "Height: " + rs.getString("height") + "\n" + "Age: " + rs.getString("age") + "\n" + "BMR: "
					+ rs.getString("bmr") + "\n";
		} catch (Exception e) {
			System.out.println("Could not retreive user data from table");
			System.out.println(e.getMessage());
		}

		return output;
	}
	
	//Reads the first name attribute of the user from the DB
	public static String readFirstName() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
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
	//Reads the last name attribute of the user from the DB
	public static String readLastName() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
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
	
	//Reads the gender attribute of the user from the DB
	public static char readGender() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
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
	
	//Reads the weight attribute of the user from the DB
	public static double readWeight() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
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
	
	//Reads the height attribute of the user from the DB
	public static double readHeight() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
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
	
	//Reads the age attribute of the user from the DB
	public static int readAge() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
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
	
	//Reads the BMR attribute of the user from the DB
	public static double readBMR() {
		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File("rootinfo.txt");
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
