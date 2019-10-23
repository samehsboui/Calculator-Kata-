package kata;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import ch.qos.logback.classic.pattern.EnsureExceptionHandling;





public class Calculator {

	
	private String delimiter;
	private String num;
	
	public Calculator(String delimiter, String num) {
		this.delimiter = delimiter;
		this.num = num;
	}
	
	
	private int sum() {
		ensureNoNegativeNumbers();
		return getNumber().sum();
	}
	
	private void ensureNoNegativeNumbers(){
		String sequence=getNumber().filter(n->n<0).mapToObj(Integer::toString).collect(Collectors.joining(","));
		if(!sequence.isEmpty())
		{
			throw new IllegalArgumentException("negatives "+sequence );
		}
	}
	
	
    private IntStream getNumber() {
    	if(num.isEmpty())
    		return IntStream.empty();
    	else
	return Arrays.stream(num.split(delimiter)).mapToInt(Integer::parseInt).map(n->n%1000);
    
    }
    
    
    public static int add(String input) {
    	
    	if(input.isEmpty())
    		return 0;
    	
    	return parseInput(input).sum();
    }
    
    
    private static String parseDelimiter(String header) {
		String delimiter = header.substring(2);
		if (delimiter.startsWith("[")) {
			delimiter = delimiter.substring(1, delimiter.length() - 1);
		}
		return Stream.of(delimiter.split("]\\["))
				.map(Pattern::quote)
				.collect(Collectors.joining("|"));
	}
    
    
	private static Calculator parseInput(String numbers) {
		if(numbers.startsWith("//")){
			
			String[] parts = numbers.split("\n",2);
			return new Calculator(parseDelimiter(parts[0]), parts[1]);
		 }
		else {
			return new Calculator(",|\n", numbers);

	}
	}
}
	

