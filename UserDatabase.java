import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class UserDatabase {
	
	
	public static void writeUserToFile(User user) {
		String output = "FirstName:" + user.getFName() + "\nLastName:" + user.getLName() + 
				"\nGender:" + user.getGender() + "\nWeight:" + user.getWeight()
				+ "\nHeight:" + user.getHeight() + "\nAge:" + user.getAge()
				+ "\nBMR:" + user.getBMR();
		try {
			File userInfo = new File("userInfo.txt");
			
			if(userInfo.createNewFile()) {
				FileWriter writer = new FileWriter("userInfo.txt");
				writer.write(output);
				writer.close();
				System.out.println("Tried to write stuff");
				
			}
			else {
				FileWriter writer = new FileWriter("userInfo.txt");
				writer.write(output);
				writer.close();
				System.out.println("Tried to write stuff. File already exists");
			}
		}
		catch (Exception e) {
			
		}
		
	}
	
}
