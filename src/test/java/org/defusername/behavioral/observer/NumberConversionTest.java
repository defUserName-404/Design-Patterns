package org.defusername.behavioral.observer;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

class NumberConversionTest {

	private static final DecimalNumber number = new DecimalNumber();
	private int numberToTest;
	private ByteArrayOutputStream outContent;

	@BeforeAll
	static void beforeAll() {
		new BinaryNumberObserver(number);
		new OctalNumberObserver(number);
		new HexadecimalNumberObserver(number);
	}

	@BeforeEach
	void setUp() {
		Random random = new Random();
		numberToTest = random.nextInt(-20, 20);
		outContent = new ByteArrayOutputStream();
	}

	@AfterEach
	void tearDown() {
		System.setOut(System.out);
		System.out.println(outContent.toString());
	}

	private String getExpectedString() {
		return ("Decimal: " + numberToTest + "\n" +
				"Binary: " + Integer.toBinaryString(numberToTest) + "\n" +
				"Octal: " + Integer.toOctalString(numberToTest) + "\n" +
				"Hexadecimal: " + Integer.toHexString(numberToTest) + "\n"
		);
	}

	@Test
	@DisplayName("Test 1")
	void shouldConvertNumberTest1() {
		System.setOut(new PrintStream(outContent));

		System.out.println("Decimal: " + numberToTest);
		number.setNumber(numberToTest);

		String expectedOutput = getExpectedString();
		Assertions.assertEquals(expectedOutput, outContent.toString());
	}

	@Test
	@DisplayName("Test 2")
	void shouldConvertNumberTest2() {
		System.setOut(new PrintStream(outContent));

		System.out.println("Decimal: " + numberToTest);
		number.setNumber(numberToTest);

		String expectedOutput = getExpectedString();
		Assertions.assertEquals(expectedOutput, outContent.toString());
	}

	@Test
	@DisplayName("Test 3")
	void shouldConvertNumberTest3() {
		System.setOut(new PrintStream(outContent));

		System.out.println("Decimal: " + numberToTest);
		number.setNumber(numberToTest);

		String expectedOutput = getExpectedString();
		Assertions.assertEquals(expectedOutput, outContent.toString());
	}

	@Test
	@DisplayName("Test 4")
	void shouldConvertNumberTest4() {
		numberToTest = 15;

		System.setOut(new PrintStream(outContent));

		System.out.println("Decimal: " + numberToTest);
		number.setNumber(numberToTest);

		String expectedOutput = getExpectedString();
		Assertions.assertEquals(expectedOutput, outContent.toString());
	}

	@Test
	@DisplayName("Test 5")
	void shouldConvertNumberTest5() {
		numberToTest = -15;

		System.setOut(new PrintStream(outContent));

		System.out.println("Decimal: " + numberToTest);
		number.setNumber(numberToTest);

		String expectedOutput = getExpectedString();
		Assertions.assertEquals(expectedOutput, outContent.toString());
	}
}