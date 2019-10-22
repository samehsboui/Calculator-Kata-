package kata;

public class Calculator {

	public static int add(String numbers) {
		if(numbers.isEmpty())
		return 0;
		else if(numbers.contains(",")){
			String[] tab=numbers.split(",");
			return Integer.parseInt(tab[0])+ Integer.parseInt(tab[1]);
		}
		else
				return Integer.parseInt(numbers) ;
	}
	
	  
	
}
