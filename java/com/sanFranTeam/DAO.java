package com.sanFranTeam;

import java.sql.*;

import java.util.ArrayList;
import java.util.Scanner;

import com.FootBallServlet.FootBallServlet;



public class DAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";
	static Scanner keyboard = new Scanner(System.in);
	public static final ArrayList<footBall> ourfootBall = new ArrayList<>();

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	public static void ConnToDB() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Trying to connect to the database");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Database connection failed");
			e.printStackTrace();
		}
		System.out.println("Connected to the Database");
	}

	public static void readFromDB() {
		ConnToDB();

//		ArrayList<footBall> ourfootBall = new ArrayList<>();
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM football.football_players;");

			while (RES_SET.next()) {
				footBall footBallInDB = new footBall();

				footBallInDB.setPlayerID(RES_SET.getString("player_id"));
				footBallInDB.setFirstName(RES_SET.getString("first_name"));
				footBallInDB.setLastName(RES_SET.getString("last_name"));
				footBallInDB.setPosition(RES_SET.getString("position"));
				footBallInDB.setTeam(RES_SET.getString("team"));
				footBallInDB.setYearsOnTeam(RES_SET.getInt("years_on_team"));
				footBallInDB.setJerseyNumber(RES_SET.getInt("jersey_number"));

				ourfootBall.add(footBallInDB);
			}

			for (footBall animal : ourfootBall) {
				System.out.println(animal.toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String insertToDB = "INSERT INTO `football`.`football_players`"
			+ "(first_name, last_name, position, team, years_on_team, jersey_number) VALUES (?,?,?,?,?,?)";
	
	public static void writeToDB(footBall addTodb) {
		footBall playerToAdd = new footBall();
		playerToAdd = addTodb;
		ConnToDB();
		
	
		try {
			PREP_STMT = CONN.prepareStatement(insertToDB);
			PREP_STMT.setString(1, playerToAdd.getFirstName());
			PREP_STMT.setString(2, playerToAdd.getLastName());
			PREP_STMT.setString(3, playerToAdd.getPosition());
			PREP_STMT.setString(4, playerToAdd.getTeam());
			PREP_STMT.setInt(5, playerToAdd.getYearsOnTeam());
			PREP_STMT.setInt(6, playerToAdd.getYearsOnTeam());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

	public static footBall aboutThefootBall() {
		footBall playerToAdd = new footBall();

		System.out.println("What is the players first name?");
		playerToAdd.setFirstName(keyboard.nextLine());

		System.out.println("What is the players last name?");
		playerToAdd.setLastName(keyboard.nextLine());

		System.out.println("What will the players position be?");
		playerToAdd.setPosition(keyboard.nextLine());

		System.out.println("What team will the player play on (1st,2nd, 3rd)?");
		playerToAdd.setTeam(keyboard.nextLine());

		System.out.println("How many years did the player play on this team?");
		playerToAdd.setYearsOnTeam(Integer.parseInt(keyboard.nextLine()));
		
		System.out.println("What is the players Jersey number?");
		playerToAdd.setJerseyNumber(Integer.parseInt(keyboard.nextLine()));

		return playerToAdd;
	}

	 private static String deletecodeFromDB = "DELETE FROM `football`.`football_players` WHERE jersey_number = ?";
	
	public static footBall deleteThefootBall(int jerseyDeleted) {
		footBall playerToDelete = new footBall();

		System.out.println("What is the jersey number of the player you want to delete?");
		playerToDelete.setJerseyNumber(Integer.parseInt(keyboard.nextLine()));

		return playerToDelete;
	}

	public static void deleteFromDB(int jerseyDeleted) {
		footBall playerToDelete = new footBall();
		
		ConnToDB();

		try {
			PREP_STMT = CONN.prepareStatement(deletecodeFromDB);
			PREP_STMT.setInt(1, jerseyDeleted);
			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	// + "(species)" + "VALUES" + "(?)";
	public static void updateToDB(footBall football) {
		footBall playerToUpdate = new footBall();
		playerToUpdate = football;
		ConnToDB();

		try {
			PREP_STMT = CONN.prepareStatement(updateInDB);

			PREP_STMT.setString(1, playerToUpdate.getFirstName());
			PREP_STMT.setString(2, playerToUpdate.getLastName());
			PREP_STMT.setString(3, playerToUpdate.getPosition());
			PREP_STMT.setString(4, playerToUpdate.getTeam());
			PREP_STMT.setLong(5, playerToUpdate.getYearsOnTeam());
			PREP_STMT.setLong(6, playerToUpdate.getJerseyNumber());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static String updateInDB = "UPDATE `football`.`football_players"
			+ "SET first_name =?, last_name =?, position=?, team=?, years_on_team=? WHERE jersey_number = ?";

	public static footBall updateThefootBall() {
		footBall playerToUpdate = new footBall();
		

		
		System.out.println("What is the players first name?");
		playerToUpdate.setFirstName(keyboard.nextLine());

		System.out.println("What is the players last name?");
		playerToUpdate.setLastName(keyboard.nextLine());

		System.out.println("What will the players position be");
		playerToUpdate.setPosition(keyboard.nextLine());

		System.out.println("Which team did the player play on (1st, 2nd, or 3rd)");
		playerToUpdate.setTeam(keyboard.nextLine());
		
		System.out.println("How many years has the played played for our team?");
		playerToUpdate.setYearsOnTeam(Integer.parseInt(keyboard.nextLine()));

		System.out.println("What Jersey number will be updated?");
		playerToUpdate.setJerseyNumber(Integer.parseInt(keyboard.nextLine()));

		return playerToUpdate;
	}

}