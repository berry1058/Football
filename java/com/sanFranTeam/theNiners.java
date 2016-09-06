package com.sanFranTeam;

import java.util.Scanner;

public class theNiners {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		String userMenuInput = null;
		boolean menuCorrect = false;

		System.out.println("Wecome to the Niners IT inventory system");

		System.out.println("Press 1 to read from the DB" + "\nPress 2 to add to the database"
				+ "\nPress 3 to delete from the datbase" + "\nPress 4 to update the database");

		do {

			userMenuInput = keyboard.nextLine();

			switch (userMenuInput) {
			case "1":
				DAO.readFromDB();
				break;

			case "2":
			//	Write to the DB
		//		DAO.writeToDB(null);
				break;

			case "3":
				DAO.deleteFromDB();
				break;

			case "4":
				DAO.updateToDB(null);
				break;

			default:
				System.out.println("You entered in an invalid option");
				menuCorrect = true;
				break;
			}
		} while (menuCorrect);
	}

}

