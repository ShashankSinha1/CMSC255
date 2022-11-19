/* **********************************************************
 * Pizza
 * **********************************************************
 * Pizza class defining the toppings
 * Shashank Sinha
 * 4/12/22
 * Course Number: 42984 and Section: C90
 * **********************************************************/
package Projects.Project6;

public class PatronPizzaTest {
    public static void main (String[] args){
        /* *******************************************************
         * Main method creating objects of patrons and pizzas
         * *******************************************************/
        Patron patron1 = new Patron("Caroline", "Budwell", "804-937-8111", "ccbudwell@vcu.edu");

        Pizza pizza1 = new Pizza(Size.SMALL);
        Pizza pizza2 = new Pizza(Size.MEDIUM);


        /* ***************************************************
         * Set the toppings, sauce, and crust for the pizzas
         * ***************************************************/
        pizza2.setMeatTopping(MeatTopping.BACON);
        pizza2.setCrust(Crust.THIN);
        pizza2.setSauce(Sauce.WHITE);
        pizza2.setVeggieTopping(VeggieTopping.SPINACH);


        /* ***********************************************************************************
         * Prints the patrons accordingly, using the toString methods created within the class
         * ***********************************************************************************/
        System.out.print(patron1.toString());
        System.out.print("\t" + pizza1.toString());
        System.out.print("\t" + pizza2.toString());

        patron1 = new Patron("Claire", "Sparks", "555-222-1111", "zwhitten@vcu.edu");

        Pizza pizza3 = new Pizza(Size.LARGE);

        pizza3.setCrust(Crust.THICK);
        pizza3.setSauce(Sauce.MARINARA);
        pizza3.setMeatTopping(MeatTopping.PEPPERONI);
        pizza3.setVeggieTopping(VeggieTopping.MUSHROOMS);

        System.out.print("\n" + patron1.toString());
        System.out.print("\t" + pizza3.toString());
    }
}
