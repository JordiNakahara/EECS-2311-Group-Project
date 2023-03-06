package EECS2311;

import java.sql.*;
import java.util.Scanner;
import java.io.File;

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
		
		try {
			con = DriverManager.getConnection(url, user, password);
			state = con.createStatement();
		} catch (Exception e) {
			System.out.println("Something went wrong. The password may be incorrect.");
		}
		
		try {
			command = "create database fitnessapp;";
			state.execute(command);
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			System.out.println(command);
		}
		
		try {
			command = "create user 'fitnessapp'@'localhost' identified by 'EECS2311'";
			state.execute(command);
		} catch (Exception e) {
			System.out.println(command);
		}
		
		try {
			command = "grant all privileges on *fitnessapp* to 'fitnessapp' @ 'localhost';";
			state.execute(command);
		} catch (Exception e) {
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
		
		sc.close();
	}
	
}
