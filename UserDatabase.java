import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class UserDatabase {

	public static void writeUserToFile(User user) {
		String output = "FirstName:" + user.getFName() + "\nLastName:" + user.getLName() + "\nGender:"
				+ user.getGender() + "\nWeight:" + user.getWeight() + "\nHeight:" + user.getHeight() + "\nAge:"
				+ user.getAge() + "\nBMR:" + user.getBMR();
		File userInfo = new File("userInfo.txt");
		try {

			if (userInfo.createNewFile()) {
				FileWriter writer = new FileWriter("userInfo.txt");
				writer.write(output);
				writer.close();

			} else {
				FileWriter writer = new FileWriter("userInfo.txt");
				writer.write(output);
				writer.close();
			}
		} catch (Exception e) {
			System.out.println("Could not write to user file!");
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
