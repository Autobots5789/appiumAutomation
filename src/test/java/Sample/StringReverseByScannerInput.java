package Sample;

import java.util.Scanner;

public class StringReverseByScannerInput {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String word = input.next();
		String reverse = "";
		for (int i = word.length() - 1; i >= 0; i--)
			reverse = reverse + word.charAt(i);
		System.out.println(reverse);
	}
}
