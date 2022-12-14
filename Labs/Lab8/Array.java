import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        String[] tokens = args[0].split(",");
        String[] customerName = new String[8];

        for (int i = 0; i < tokens.length; i++) {
            customerName[i] = tokens[i];
        }

        displayNames(customerName);
        System.out.println();

        customerName[6] = customerName[4];
        customerName[7] = customerName[5];
        customerName[4] = "Rick";
        customerName[5] = "Jessica";
        displayNames(customerName);
        System.out.println();

        String[] reverseNames = reverseNames(customerName);
        displayNames(reverseNames);
        System.out.println();

        reverseNames2(customerName);
        displayNames(customerName);
        System.out.println();

        for (int i = 0; i < customerName.length; i++) {
            if (customerName[i] != null && customerName[i].equals("Rick")) {
                for(int j = i; j < customerName.length - 1; j++)
                {
                    customerName[j] = customerName[j+1];
                }
                customerName[customerName.length-1] = null;
            }
        }
        displayNames(customerName);
    }

    public static void displayNames(String[] customerName) {
        for (int i = 0; i < customerName.length; i++) {
            System.out.println(customerName[i]);
        }
    }

    public static String[] reverseNames(String[] names) {
        String[] reverse = new String[8];

        reverse[7] = names[0];
        reverse[6] = names[1];
        reverse[5] = names[2];
        reverse[4] = names[3];
        reverse[3] = names[4];
        reverse[2] = names[5];
        reverse[1] = names[6];
        reverse[0] = names[7];

        return reverse;
    }

    public static void reverseNames2(String[] names){
        for (int i = 0; i < names.length / 2; i++) {
            String j = names[i];
            names[i] = names[names.length - i - 1];
            names[names.length - i - 1] = j;
        }
    }
}
