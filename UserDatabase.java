import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.sql.*;

public class UserDatabase {

	public static void writeUserToFile(User user) {

		String url = "jdbc:mysql://localhost:3306/fitnessapp";
		String user = "root";
		String password = "";
		File databasePassword = new File ("rootinfo.txt");

		try {
			Scanner sc = new Scanner(databasePassword);
			while (sc.hasNextLine()) {
				password = password + "\n" + sc.nextLine();
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("Could not read root password");
		}

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Could not create connection");
		}

		try {
			String command = "insert into userdata (first_name, last_name, gender,
			 weight, height, age, bmr) values (" + user.getFName + ", " +
			  user.getLName + ", " + user.getGender + ", " + user.getWeight
			   + ", " + user.getHeight + ", " + user.getBMR + ");";
		} catch (Exception e) {
			System.out.println("Could not add user data to table")
		}




	}

	public static String readUserFile() {
		String output = "";
		File userInfo = new File("userInfo.txt");

		try {
			Scanner sc = new Scanner(userInfo);
			while (sc.hasNextLine()) {
				output = output + "\n" + sc.nextLine();
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("Could not read user file!");
			return "Error reading user file";
		}

		return output;
	}

	public static String readFirstName() {
		String output = "";
		File userInfo = new File("userInfo.txt");

		try {
			Scanner sc = new Scanner(userInfo);
			output = output + sc.nextLine();
			sc.close();
		} catch (Exception e) {
			System.out.println("Could not read user's first name!");
			return "Error";
		}

		int temp = output.indexOf(':') + 1;
		output = output.substring(temp);
		return output;

	}

	public static String readLastName() {
		String output = "";
		File userInfo = new File("userInfo.txt");

		try {
			Scanner sc = new Scanner(userInfo);
			sc.nextLine();
			output = output + "\n" + sc.nextLine();
			sc.close();
		} catch (Exception e) {
			System.out.println("Could not read user's last name!");
			return "Error";
		}

		int temp = output.indexOf(':') + 1;
		output = output.substring(temp);
		return output;

	}

	public static char readGender() {
		char output = 0;
		String input = "";
		File userInfo = new File("userInfo.txt");

		try {
			Scanner sc = new Scanner(userInfo);
			sc.nextLine();
			sc.nextLine();
			input = sc.nextLine();
			sc.close();
		} catch (Exception e) {
			System.out.println("Could not read user's gender!");
			return 0;
		}

		int temp = input.indexOf(':') + 1;
		output = input.charAt(temp);
		return output;

	}

	public static int readWeight() {
		int output = 0;
		String input = "";
		File userInfo = new File("userInfo.txt");

		try {
			Scanner sc = new Scanner(userInfo);
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			input = sc.nextLine();
			sc.close();
		} catch (Exception e) {
			System.out.println("Could not read user's weight!");
			return 0;
		}

		int temp = input.indexOf(':') + 1;
		input = input.substring(temp);
		output = Integer.parseInt(input);
		return output;

	}

	public static int readHeight() {
		int output = 0;
		String input = "";
		File userInfo = new File("userInfo.txt");

		try {
			Scanner sc = new Scanner(userInfo);
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			input = sc.nextLine();
			sc.close();
		} catch (Exception e) {
			System.out.println("Could not read user's height!");
			return 0;
		}

		int temp = input.indexOf(':') + 1;
		input = input.substring(temp);
		output = Integer.parseInt(input);
		return output;

	}

	public static int readAge() {
		int output = 0;
		String input = "";
		File userInfo = new File("userInfo.txt");

		try {
			Scanner sc = new Scanner(userInfo);
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			input = sc.nextLine();
			sc.close();
		} catch (Exception e) {
			System.out.println("Could not read user's age!");
			return 0;
		}

		int temp = input.indexOf(':') + 1;
		input = input.substring(temp);
		output = Integer.parseInt(input);
		return output;

	}

}
