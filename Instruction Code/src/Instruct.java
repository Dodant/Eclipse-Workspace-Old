import java.lang.*;
import java.util.*;

public class Instruct {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		char firstLetter = input.charAt(0);
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("7800", "CLA");	hm.put("7400", "CLE");	hm.put("7200", "CMA");	hm.put("7100", "CME");
		hm.put("7080", "CIR");	hm.put("7040", "CIL");	hm.put("7020", "INC");	hm.put("7010", "SPA");
		hm.put("7008", "SNA");	hm.put("7004", "SZA");	hm.put("7002", "SZE");	hm.put("7001", "HLT");
		hm.put("F800", "INP");	hm.put("F400", "OUT");	hm.put("F200", "SKI");	hm.put("F100", "SKO");
		hm.put("F080", "ION");	hm.put("F040", "IOF");
		
		switch(firstLetter) {
			case '0':
			case '8':
				System.out.println("AND " + input.substring(1));
				break;
			case '1':
			case '9':
				System.out.println("ADD " + input.substring(1));
				break;
			case '2':
			case 'A':
				System.out.println("LDA " + input.substring(1));
				break;
			case '3':
			case 'B':
				System.out.println("STA " + input.substring(1));
				break;
			case '4':
			case 'C':
				System.out.println("BUN " + input.substring(1));
				break;
			case '5':
			case 'D':
				System.out.println("BSA " + input.substring(1));
				break;
			case '6':
			case 'E':
				System.out.println("ISZ " + input.substring(1));
				break;
			case '7':
			case 'F':
				String symbol = hm.get(input);
				if(symbol == null)
					System.out.println("nop");
				else
					System.out.println(input + " -> " + symbol);
				break;
		}
	}
}