package org.defusername.creational.singleton;

import static org.junit.jupiter.api.Assertions.assertSame;

class DatabaseOperationTest {

	private DatabaseOperation databaseOperation;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		databaseOperation = DatabaseOperation.getInstance();
	}

	@org.junit.jupiter.api.AfterEach
	void tearDown() {
		databaseOperation = null;
	}

	@org.junit.jupiter.api.Test
	void getInstance() {
		assertSame(DatabaseOperation.getInstance(), databaseOperation);
	}

	@org.junit.jupiter.api.Test
	void createDatabase() {
		databaseOperation.createDatabase();
	}

	@org.junit.jupiter.api.Test
	void writeToDatabase() {
		databaseOperation.writeToDatabase();
	}

	@org.junit.jupiter.api.Test
	void readFromDatabase() {
		databaseOperation.readFromDatabase();
	}

	@org.junit.jupiter.api.Test
	void deleteDatabase() {
		databaseOperation.deleteDatabase();
	}
}