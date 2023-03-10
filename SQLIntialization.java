import java.sql.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class SQLIntialization {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		System.out.println("Please input MySQL root password:");
		Scanner sc = new Scanner(System.in);
		String password = sc.nextLine();
		Connection con;
		Statement state = null;
		String command = null;
		File rootinfo = new File("rootinfo.txt");

		try {
			rootinfo.createNewFile();
			FileWriter writer = new FileWriter("rootinfo.txt");
			writer.write(password);
			writer.close();
		} catch (Exception e) {
			System.out.println("File already exists");
		}

		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Something went wrong. The password may be incorrect.");
		}

		try {
			command = "use fitnessapp;";
			command = "DROP DATABASE fitnessapp;";
			state.execute(command);
		} catch (Exception e) {
			System.out.println("Could not clear database");
		}

		try {
			command = "create database fitnessapp;";
			state.execute(command);
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			System.out.println(command);
		}

		try {
			command = "use fitnessapp;";
			state.execute(command);
			command = "create table userdata(first_name varchar (100), last_name varchar(100), gender varchar(1), weight decimal(10, 5), height decimal(10, 5), age int, bmr decimal(10,5));";
			state.execute(command);
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			System.out.println(command);
		}

		try {
			command = "create table arms(name varchar(100));";
			state.execute(command);
			command = "create table abs(name varchar(100));";
			state.execute(command);
			command = "create table legs(name varchar(100));";
			state.execute(command);
			command = "create table chest(name varchar(100));";
			state.execute(command);
			command = "create table cardio(name varchar(100));";
			state.execute(command);
		} catch (Exception e) {
			System.out.println(command);
		}

		try {
			command = "insert into arms(name) values ('tricep dips'), ('inch worms'), ('plank push up'), ('plank walk'), ('extended plank hold');";
			state.execute(command);
			command = "insert into abs(name) values ('situps'), ('plank'), ('russian twists'), ('v sit'), ('bicycle crunch');";
			state.execute(command);
			command = "insert into legs(name) values ('squats'), ('lunges'), ('flutter kicks'), ('calf raises'), ('run on the spot');";
			state.execute(command);
			command = "insert into chest(name) values ('pike push-up'), ('dive bomber push-up'), ('shoulder taps'), ('wide grip push-up'), ('elevated push-up');";
			state.execute(command);
			command = "insert into cardio(name) values ('burpees'), ('jumping jacks'), ('mountain climbers'), ('high knees'), ('reverse kick lunge');";
			state.execute(command);
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(command);
		}

		sc.close();
	}

}
