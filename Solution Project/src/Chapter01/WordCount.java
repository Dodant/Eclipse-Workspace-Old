package Chapter01;
// 1.6 단어 출현빈도 세기 
import java.util.*;

public class WordCount {

	public static void main(String[] args) {
		Map<String, Integer> table = new TreeMap<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Text : ");
		String text = sc.nextLine();
		
		StringTokenizer stz = new StringTokenizer(text);
		while(stz.hasMoreTokens()) {
			String word = stz.nextToken().toLowerCase();
			if(table.containsKey(word)) {
				Integer count = table.get(word);
				table.put(word, count + 1);
			} else {
				table.put(word, 1);
			}
		}
		for(Map.Entry<String, Integer> entry : table.entrySet()) {
			System.out.println(entry);
		}
	}
}
