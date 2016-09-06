package com.sanFranTeam;

public class footBall {
		
		private String playerID = null;
		private String firstName = null;
		private String lastName = null;
		private String position = null;
		private String team = null;
		private int yearsOnTeam = 0;
		private int jerseyNumber = 0;
	
		
		public footBall(String playerID, String firstName, String lastName, String position, String team,
				int yearsOnTeam, int jerseyNumber) {
			super();
			this.playerID = playerID;
			this.firstName = firstName;
			this.lastName = lastName;
			this.position = position;
			this.team = team;
			this.yearsOnTeam = yearsOnTeam;
			this.jerseyNumber = jerseyNumber;
		}


		public footBall() {
			super();
		}


		public String getPlayerID() {
			return playerID;
		}


		public void setPlayerID(String playerID) {
			this.playerID = playerID;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getPosition() {
			return position;
		}


		public void setPosition(String position) {
			this.position = position;
		}


		public String getTeam() {
			return team;
		}


		public void setTeam(String team) {
			this.team = team;
		}


		public int getYearsOnTeam() {
			return yearsOnTeam;
		}


		public void setYearsOnTeam(int yearsOnTeam) {
			this.yearsOnTeam = yearsOnTeam;
		}


		public int getJerseyNumber() {
			return jerseyNumber;
		}


		public void setJerseyNumber(int jerseyNumber) {
			this.jerseyNumber = jerseyNumber;
		}
	
		
	
}
