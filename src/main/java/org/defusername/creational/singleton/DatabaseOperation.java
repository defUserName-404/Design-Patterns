package org.defusername.creational.singleton;

public class DatabaseOperation {

	private static DatabaseOperation instance;

	// private constructor to prevent more than one instance to be created
	private DatabaseOperation() {
	}

	public static DatabaseOperation getInstance() {
		if (instance == null)
			instance = new DatabaseOperation();
		return instance;
	}

	public void createDatabase() {
		System.out.println("Database created");
	}

	public void writeToDatabase() {
		System.out.println("Write to database successful");
	}

	public void readFromDatabase() {
		System.out.println("Reading from database");
	}

	public void deleteDatabase() {
		System.out.println("Deleting database");
	}
}