package fr.runadium.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
}
