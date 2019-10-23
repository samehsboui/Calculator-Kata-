package fr.runadium.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.*;
import kata.Calculator;

public class CalculatorTest {

	
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
	public void thrownOnNegative() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->Calculator.add("-3"));
	}
	
	@Test
	public void thrownOnNegativeWithAllNumbersInMessage() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->Calculator.add("-3,-1,-2"));
	}
	
	@Test void shouldNotAcceptBiggerThan1000() {
		assertEquals(2, Calculator.add("1002"));

	}
	
	@Test void shouldAcceptAnyLength() {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));

	}
	
	@Test
	public void acceptsMultipleDelimiters() {
		assertEquals(6,Calculator.add("//[-][;]\n1-2;3"));
	}
	
}
