import java.util.Scanner;

public class PrintStrings {
	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter two words:");
	
	String s1 = input.nextLine();
	String s2 = input.nextLine();
	
	if (s1.compareTo(s2) <= 0)
	{
		System.out.println(s1 + " " + s2);
	}
	else
	{
		System.out.println(s2 + " " + s1);
	}
	}
}
		