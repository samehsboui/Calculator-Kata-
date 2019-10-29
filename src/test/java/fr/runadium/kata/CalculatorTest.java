package fr.runadium.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.*;
import kata.Calculator;

public class CalculatorTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void shouldReturnZero() {
		assertEquals(0,Calculator.add(""));
	}
	
	
	@Test
	public void shouldReturnOneNumber() {
		assertEquals(1,Calculator.add("1"));
	}
	
	
	@Test
	public void shouldReturnSumOfTwo() {
		assertEquals(3,Calculator.add("1,2"));
	}
	
	
	@Test
	public void shouldReturnSumOfMultiple() {
		assertEquals(6, Calculator.add("1,2,3"));
	}
	
	
	@Test void shouldAcceptNewLine() {
		assertEquals(6, Calculator.add("1,2\n3"));

	}
	
	@Test void shouldAcceptDelimiterSpecified() {
		assertEquals(3, Calculator.add("//;\n1;2"));

	}
	
	
	@Test
	public void negativeNumberThrown() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negative number: -3");

		Calculator.add("-3");
	}

	@Test
	public void throwsOnNegativeNumbersWithAllNumbersInExceptionMessage() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negative number: -3,-5,-13");

		Calculator.add("1,-3,5,-5,-13");
	}

	@Test
	public void mapsNumbersAbove1000ToLastThreeDigits() {
		assertEquals(Calculator.add("1002"), 2);
		assertEquals(Calculator.add("1040,10002"),42);
	}

	@Test
	public void acceptsDelimiterOfArbitraryLength() {
		assertEquals(Calculator.add("//[***]\n1***2***3"),6);
	}

	@Test
	public void acceptsMultipleDelimiters() {
		assertEquals(Calculator.add("//[-][;]\n1-2;3"), 6);
		assertEquals(Calculator.add("//[--][...]\n2--3...4"), 9);
	}
}
