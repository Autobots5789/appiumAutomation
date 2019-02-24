package Programs;

import java.lang.StringBuilder;

//public class StringReverseByWords {
//	public static void reverseStringByWords(String string) {
//		string = "How are you";
//	    StringBuilder stringBuilder = new StringBuilder();
//	    String[] words = string.split(" ");
//
//	    for (int j = words.length-1; j >= 0; j--) {
//	        stringBuilder.append(words[j]).append(' ');
//	    }
//	    System.out.println("Reverse words: " + stringBuilder);
//	}

import java.io.*;

public class StringReverseByWords {
	public static void main(String[] args) {
		String input = "";
		System.out.println("Enter the input string");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			char[] charArray = input.toCharArray();
			for (int i = charArray.length - 1; i >= 0; i--)
				System.out.print(charArray[i]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
