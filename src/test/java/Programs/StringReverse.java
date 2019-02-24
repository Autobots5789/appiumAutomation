package Programs;

public class StringReverse {
    public static void main(String[] args) {
        String s1 = "Hello madam";
        for(int i=s1.length()-1;i>=0;i--)
            {
                System.out.print(s1.charAt(i));
            }
    }
}