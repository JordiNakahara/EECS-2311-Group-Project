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
			System.out.println("Something went wrong while trying to write to the file.");
		}

	}
	
	public static String readUserFile() {
		String output = "";
		File userInfo = new File("userInfo.txt");
		
		try {
			Scanner sc = new Scanner(userInfo);
			while(sc.hasNextLine()) {
				output = output + "\n" + sc.nextLine();
			}
		} catch (Exception e) {
			
		}
		
		return output;
	}

}
