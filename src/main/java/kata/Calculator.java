package kata;

import java.util.Arrays;
import java.util.stream.Stream;





public class Calculator {

	
	private String delimiter;
	private String num;
	
	public Calculator(String delimiter, String num) {
		this.delimiter = delimiter;
		this.num = num;
	}
	
    private int sum() {
	return Arrays.stream(num.split(delimiter)).mapToInt(Integer::parseInt).sum();
    }
    
    
    public static int add(String input) {
    	
    	if(input.isEmpty())
    		return 0;
    	
    	return parseInput(input).sum();
    }
    
	private static Calculator parseInput(String numbers) {
		if(numbers.startsWith("//")){
			
			String[] parts = numbers.split("\n",2);
			return new Calculator(parts[0].substring(2), parts[1]);
		 }
		else {
			return new Calculator(",|\n", numbers);

	}
	}
}
	

