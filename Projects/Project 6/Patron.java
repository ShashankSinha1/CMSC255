/* **********************************************************
 * Pizza
 * **********************************************************
 * Pizza class defining the toppings
 * Shashank Sinha
 * 4/12/22
 * Course Number: 42984 and Section: C90
 * **********************************************************/
package Projects.Project6;
import java.util.ArrayList;

public class Patron {
    /**
     * Instance variables for the Patron class
     */
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private ArrayList<Pizza> pizzas;

    /**
     * Default constructor assigning default values to the instance variables
     */
    public Patron(){
        firstName = null;
        lastName = null;
        phone = null;
        email = null;
        pizzas = new ArrayList<>();
    }
    /**
     * Parameterized constructor passing in variables from the main method and reassigning it to the instance variables
     */
    public Patron (String firstName, String lastName, String phone, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        pizzas = new ArrayList<Pizza>();
    }


    /**
     * Getter and setter methods for each of the instance variables
     */
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String name){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void addPizza(Pizza newPizza){
        pizzas.add(newPizza);
    }

    public int getNumPizzas(){
        return pizzas.size();
    }

    public ArrayList<Pizza> getPizzas(){
        return this.pizzas;
    }

    /**
     * toString method returning each of the instance variables, indented on a new line
     */
    public String toString(){
        String result = firstName + " " + lastName
                + "\n" + phone
                + "\n" + email
                + "\nPizzas:\n";
        for (int i = 0; i < getNumPizzas(); i++){
            result += pizzas.get(i).toString();
        }
        return result;
    }




}
