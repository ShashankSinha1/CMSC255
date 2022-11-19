/* **********************************************************
 * Pizza
 * **********************************************************
 * Pizza class defining the toppings
 * Shashank Sinha
 * 4/12/22
 * Course Number: 42984 and Section: C90
 * **********************************************************/
package Projects.Project6;

public class Pizza {
    /**
     * Enumerated types for constant variables
     */
    Size size;
    Crust crust;
    Sauce sauce;
    MeatTopping meatTopping;
    VeggieTopping veggieTopping;
    /**
     * Default constructor assigning default values to the instance variables
     */
    public Pizza(){
        size = Size.SMALL;
        crust = Crust.HAND_TOSSED;
        sauce = Sauce.MARINARA;
        meatTopping = MeatTopping.none;
        veggieTopping = VeggieTopping.none;
    }

    /**
     * Parameterized constructor passing in variables from the main method and reassigning it to the instance variables
     */
    public Pizza(Size size){
        this.size = size;
        crust = Crust.HAND_TOSSED;
        sauce = Sauce.MARINARA;
        meatTopping = MeatTopping.none;
        veggieTopping = VeggieTopping.none;
    }
    /**
     * Getter and setter methods for each of the instance variables
     */
    public Size getSize(){
        return size;
    }

    public void setSize (Size size){
        this.size = size;
    }

    public Crust getCrust(){
        return crust;
    }

    public void setCrust (Crust crust){
        this.crust = crust;
    }

    public Sauce getSauce(){
        return sauce;
    }

    public void setSauce (Sauce sauce){
        this.sauce = sauce;
    }

    public MeatTopping getMeatTopping(){
        return meatTopping;
    }

    public void setMeatTopping (MeatTopping meatTopping){
        this.meatTopping = meatTopping;
    }

    public VeggieTopping getVeggieTopping (){
        return veggieTopping;
    }

    public void setVeggieTopping(VeggieTopping veggieTopping){
        this.veggieTopping = veggieTopping;
    }

    /**
     * toString method returning each of the instance variables, indented on a new line
     */
    public String toString(){
        String result =
                "\n" + "\t" + size +
                "\n" + "\t" + crust +
                "\n" + "\t" + sauce +
                "\n" + "\t" + meatTopping +
                "\n" + "\t" + veggieTopping +
                "\n";
        return result;
    }




}
