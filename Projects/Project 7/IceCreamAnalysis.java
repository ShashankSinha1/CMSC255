package Projects; /****************************************************************************
 * Ice Cream Analysis
 *************************************************************************************************************************************
 * Create arrays for ice cream flavors, favorability, calories, and cost and create methods that ask different things from the arrays.
 *____________________________________________________________________________________________________________________________________
 * Shashank Sinha
 * 03/17/22
 * Course Number: 42984 and Section: C90
 ****************************************************************************/

import java.util.Scanner;

public class IceCreamAnalysis{
        public static void main(String[] args) {
            Scanner scr = new Scanner(System.in);

            /***********************************************************************
             * Create four different arrays: flavors, favorability, calors, and cost
             ***********************************************************************/

            String[] flavors = {"Vanilla", "Chocolate", "Mint Chocolate Chip", "Cookies N’ Cream ", "Strawberry", "Cookie Dough", "Salted Caramel", "Moose Tracks"};

            double[] favorability = new double[]{.78, .62, .59, .33, .45, .67, .72, .49};
            double[] calories = new double[]{137.6, 143.5, 151.3, 162.8, 126.6, 168.4, 139.1, 158.2};
            double[] cost = new double[]{1.98, 2.14, 2.23, 2.17, 2.09, 2.12, 2.07, 2.34};

            /***************************************************************************
             * Using system.out.printf, output each method and round to 3 decimal places
            ****************************************************************************/

            System.out.printf("The average calorie amount is: %.3f", calcMean(calories));
            System.out.println();

            System.out.printf("The average cost per gallon is: %.3f", calcMean(cost));
            System.out.println();

            System.out.printf("The highest favorability is: %.3f", findGreatest(favorability));
            System.out.println();

            System.out.printf("The least cost per gallon is: %.3f", findSmallest(cost));
            System.out.println();

            /*****************************************
             * Output the best value flavor as println
             *****************************************/
            System.out.println("The best value is: " + findBestValue(flavors, favorability, cost));

            findSmallestTwo(flavors, calories);

            /****************************************
             * User is asked to input a random flavor
             ****************************************/

            System.out.println("Enter a flavor:");
            String flavor = scr.nextLine().trim();

            /***********************************************************************
             * Using the inputted flavor, it calls in the findFlavor method to check
             * whether the flavor inputted correlates to one of the flavors listed
             * and prints out accordingly.
             ***********************************************************************/

            if (findFlavor(flavors, flavor) == true) {
                System.out.println(flavor + " is a flavor in the array");
            }
            else {
                System.out.println(flavor + " is not a flavor in the array");
            }
        }
            /****************************************************************
             * Find the mean of the given array by using array length
             * to figure out how many values are in the array, then dividing
             * them by the sum, which is calculated in a for loop based on
             * how many values are within the array
             ****************************************************************/
            public static double calcMean(double[] values)
            {
                double length = values.length;
                double total = 0;

                for (int i = 0; i < values.length; i++){
                    total += values[i];
                }

                double mean = total / length;
                return mean;
            }
            /****************************************************************
             * Find the greatest value using array length to figure out how
             * many values are in the array and then using a for loop,
             * converting values of assigned "max" if the value within the
             * array is larger than that of the previous "max"
             ****************************************************************/


            public static double findGreatest(double[] values)
            {
                double max = values[0];
                for (int i = 1; i < values.length; i++){
                    if (values[i] > max)
                    {
                        max = values[i];
                    }
                }
                return max;
            }
            /****************************************************************
             * Find the smallest value using array length to figure out how
             * many values are in the array and then using a for loop,
             * converting values of assigned "min" if the value within the
             * array is lower than that of the previous "min"
             ****************************************************************/

            public static double findSmallest(double[] values)
            {
                double min = values[0];
                for (int i = 1; i < values.length; i++){
                    if (values[i] < min)
                    {
                        min = values[i];
                    }
                }
                return min;

            }
            /**************************************************************************
             * Find the best value rating out of the flavors using the formula given.
             * Using a for loop after the valueRating array is initialized, this
             * assigns the value rating number to 'i', starting from 0.
             * Then, to find which flavor correlates to the largest value rating,
             * using the same for loop to find the greatest, this will return
             * bestValue as a string, correlating to the flavor with the highest rating.
             ***************************************************************************/

            public static String findBestValue(String[] flavors, double[] favorability, double[] cost)
            {
                double[] valueRating = new double[8];
                for (int i = 0; i < flavors.length; i++) {
                    valueRating[i] = favorability[i] * (5.0 - cost[i]);
                }
                String bestValue = "";

                double largest = 0;
                for (int i = 0; i < valueRating.length; i++) {
                    if (valueRating[i] > largest) {
                        largest = valueRating[i];
                        bestValue = flavors[i];
                    }
                }
                return bestValue;
            }

            /*********************************************************************
             * Find the smallest 2 values similarly to how the findSmallest
             * method was done, using a for loop that is dependent on the
             * array length. Within if statements, determine if a value is lower
             * than the other, and assign it to the smallest variable accordingly.
             * Given 'i' within the for loop, use it to assign the name to
             * the corresponding smallest value.
             ********************************************************************/

            public static String[] findSmallestTwo(String[] flavors, double[] values)
            {
                double smallest = values[0];
                double secondSmallest = values[1];
                String smallestFlavor = flavors[0];
                String secondSmallestFlavor = flavors[1];
                double temp;

                if (smallest > secondSmallest)
                {
                    temp = smallest;
                    smallest = secondSmallest;
                    secondSmallest = temp;
                }

                for (int i = 2; i < values.length; i++)
                {
                    if (values[i] < smallest)
                    {
                        secondSmallest = smallest;
                        secondSmallestFlavor = smallestFlavor;
                        smallest = values[i];
                        smallestFlavor = flavors[i];
                    }

                    else if (values[i] < secondSmallest && values[i] != smallest)
                    {
                        secondSmallest = values[i];
                        secondSmallestFlavor = flavors[i];
                    }

                }
                System.out.println("The least two flavors for calories:");
                System.out.println(smallestFlavor);
                System.out.println(secondSmallestFlavor);
                return flavors;

            }
            /****************************************************************
             * Initialize a boolean variable, and pass in a string array, as
             * well as the inputted string from the user. Using .equals,
             * determine whether the value is within the array. If true,
             * return the true value. Else return false, and pass call back
             * to main method, where the printing is executed.
             ****************************************************************/

            public static boolean findFlavor(String[] flavors, String flavor) {
                boolean ifFound = false;
                for (String x : flavors) {
                    if (x.equals(flavor))
                    {
                        ifFound = true;
                        return ifFound;
                    }
                    else
                    {
                        ifFound = false;
                    }
                }
                return ifFound;
            }

}
