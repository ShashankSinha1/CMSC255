/**************************************************************************** 
 * NumberPlay
 **************************************************************************** 
 * Check if the number is divisible by 11 
 * Shashank Sinha 
 * Feb. 03, 2022
 * Course Number: 42984 and Section: C90 
 ****************************************************************************/ 



import java.util.Scanner;

public class NumberPlay {
    public static void main(String[] args){
		
        Scanner input = new Scanner(System.in);
		int number, sum = 0;

//Enter number
        System.out.println("Would you like to randomly enter a number (1) or enter it yourself (2).");
        int choice = input.nextInt();

//Prompt the user to pick a choice between 1 and 2 and proceed 
        if(choice == 1){
			
            number = (int)(Math.random()*1000000);
            System.out.println(number);
			
        } 
		
		else if(choice == 2) {
			
            System.out.println("Enter a 6-digit number.");
            number = input.nextInt();
            if(number > 999999 || number < 99999)
				
            {
                System.out.println("Incorrect input");
                return;
            }
        } 
		else {
			
            System.out.println("Incorrect input");
            return;
        }

//When choice is choosen by the user, add the digits up in the six digit number
		int temp = number;

		while (number != 0) {	
			sum += number % 10;
			number = number / 10;
		}
//Display the output if the sum of digits is divisible by 11
		if (sum % 11 == 0) {
			
            System.out.println(temp + " is divisible by 11");
            return;
        } 
//Display the output if the sum of digits is not divisible by 11
		else if (sum % 11 != 0) {
            System.out.println(temp + " is not divisible by 11");
            return;
        }       
    }
}