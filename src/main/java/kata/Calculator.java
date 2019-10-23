package kata;

import java.util.Arrays;
import java.util.stream.Stream;





public class Calculator {

	public static int add(String numbers) {
		if(numbers.isEmpty())
		return 0;
		
		else if(numbers.contains(",")){
			Stream<String> num=Arrays.stream(numbers.split(","));
			return num.mapToInt(Integer::parseInt).sum();
		}
		else return Integer.parseInt(numbers);
	}

	}
	  
	

