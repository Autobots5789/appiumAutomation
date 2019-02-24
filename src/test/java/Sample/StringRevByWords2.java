package Sample;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;

public class StringRevByWords2 {
	public static void main(String[] args) {

		System.out.print("Please enter your string: \n");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		//String find=scanner.nextLine();

		String reverse = new StringBuffer(name).reverse().toString();
		String rev = reverse.toLowerCase();
		System.out.println("Reversed string:\n" + rev);

		StringTokenizer st = new StringTokenizer(name);
		System.out.println("Total number of Words in the input string:" + " " + st.countTokens());

		int count = 0;
		int k = 0;
		
		for (int i = 0; i < name.length(); i++) {
			
			k = name.toLowerCase().indexOf(name.toLowerCase(), k + name.length());
			System.out.println(k);
			if (k == -1)
				break;
			else
				count++;
		}
		System.out.println("The string occurred " + count + " times");
		// System.out.println("The string occured:" + " " + k + " " + count + " " + "times");
		scanner.close();
	}

}
