/**************************************************************************** 
 * EmojiSign
 **************************************************************************** 
 * Find the total cost of the emoji
*_____________________________________________________ 
 * Shashank Sinha 
 * 02/24/2022
 * Course Number: 42984 and Section: C90
 ****************************************************************************/ 

import java.util.Scanner;

public class EmojiSign {
	public static void main(String[] args) {
	/*****************************************************************************
	Create a new Scanner instance that declares scr as an object of Scanner class.
	*****************************************************************************/
	Scanner scr = new Scanner(System.in); 
	
	/********************************************
	When answer is yes, the do while loop repeats
	********************************************/
	
	do {
		
		/*********************************************
		Declaring the variables required for the code.
		*********************************************/
		
		double surfaceArea, volume, stringCost, neonCost, plasticCost, totalCost;
	
		/******************************************************
		Prompt the user to input a radius value using scr.next.
		******************************************************/

		System.out.println("Enter the radius: ");
		double radius = scr.nextDouble();
		
		/*********************************************************************************
		Prompt the user to input the string they would like on their emoji using scr.next.
		*********************************************************************************/

		System.out.println("Enter the string you would like on your sign: ");
		scr.nextLine();
		String line = scr.nextLine();
		
		/**********************************
		Initialize stringLength to equal 0.
		**********************************/

		int stringLength = 0;
		
		/**************************************************************************************************
		Using the for loop, when the characaters in the user's string are counted, don't include the spaces.
		**************************************************************************************************/

		for(int i = 0; i < line.length(); i++) {    
            if(line.charAt(i) != ' ')    
                stringLength++;    
        }    
		
		/*************************************************************************************
		Prompt the user to input what kind of emoji they would like on the sign using scr.next
		*************************************************************************************/
		
		System.out.println("Which emoji would you like on your sign: ");
		String emoji = scr.nextLine();
		
		

		/**************************************
		Declaring and initialize emojiCost to 0
		**************************************/
		double emojiCost = 0;

	/***************************************************************************************************************
	Using if statements, if the user enters Glasses, 4 eyes, or Cool for their emoji, then set the emojiCost to 500.
	***************************************************************************************************************/
		
	if ((emoji.equalsIgnoreCase("Glasses") || emoji.equalsIgnoreCase("4 eyes") || emoji.equalsIgnoreCase("Cool")) == true){
			emojiCost = 500.00;
		}
	/************************************************************************************************
	If the user enters Without Glasses, Wink, or Smile for their emoji, then set the emojiCost to 450.
	*************************************************************************************************/
	
	if ((emoji.equalsIgnoreCase("Without glasses") || emoji.equalsIgnoreCase("Wink") || emoji.equalsIgnoreCase("Smile")) == true){
			emojiCost = 450.00;
		}
		
		/***********************************************
		Enter in the formulas for surfaceArea and volume
		************************************************/
		surfaceArea = 4.00 * Math.PI * Math.pow(radius, 2);
		volume = (4.00/3.00) * Math.PI * Math.pow(radius, 3);
		
	/********************************************************************************************************************
	Set neonCost equal to the volume * 3.45, plasticCost to the surfaceArea * 2.75, and stringCost to stringLength * 4.50.
	*********************************************************************************************************************/

		neonCost = volume * 3.45;
		plasticCost = surfaceArea * 2.75;
		stringCost = stringLength * 4.50;

		/*************************************************************************************
		Set the totalCost equal to the sum of emojiCost, stringCost, neonCost, and plasticCost
		**************************************************************************************/
		
		totalCost = emojiCost + stringCost + neonCost + plasticCost;	
		
		/***********************************************************************
		Output "Your sign with" plus whatever the user inputted for their string
		***********************************************************************/
				
		System.out.print("Your sign with \"" + line + "\"");
		
		/**************************************************
		Output the total cost rounded to two decimal places
		**************************************************/
		
		System.out.printf(" will cost $%,.2f", totalCost);
		System.out.print(".");
	
		System.out.println();
		
		/*************************************************************************
		Ask the user whether they would like to create another sign using scr.next
		*************************************************************************/
		
		System.out.println("Would you like to create another sign? Enter yes to continue. ");
		
		/*****************************************************************
		If the answer is yes, then the whole do while loop will loop again.
		******************************************************************/
		
	} while(scr.nextLine().trim().equalsIgnoreCase("yes")); 
		
	}
}
