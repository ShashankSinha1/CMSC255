/* **********************************************************
 * Pizza
 * **********************************************************
 * Pizza class defining the toppings
 * Shashank Sinha
 * 4/12/22
 * Course Number: 42984 and Section: C90
 * **********************************************************/
package Projects.Project6;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class Project6Tests {

    //region PatronTests
    public void Patron_instanceCountTest() {
        Patron testPatron = new Patron();
        @SuppressWarnings("rawtypes") Class c = testPatron.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at " +
                            "the " + "number of instance variables we",
                    5,
                    c.getDeclaredFields().length
            );
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void Patron_instanceVariablesTest() {
        Patron testPatron = new Patron();
        instanceVariablePrivate("firstName", testPatron);
        instanceVariablePrivate("lastName", testPatron);
        instanceVariablePrivate("phone", testPatron);
        instanceVariablePrivate("email", testPatron);
        instanceVariablePrivate("pizzas", testPatron);

        instanceVariableStatic("firstName", testPatron);
        instanceVariableStatic("lastName", testPatron);
        instanceVariableStatic("phone", testPatron);
        instanceVariableStatic("email", testPatron);
        instanceVariableStatic("pizzas", testPatron);

        instanceVariableCorrectType("firstName", String.class, testPatron);
        instanceVariableCorrectType("lastName", String.class, testPatron);
        instanceVariableCorrectType("phone", String.class, testPatron);
        instanceVariableCorrectType("email", String.class, testPatron);
        instanceVariableCorrectType("pizzas", ArrayList.class, testPatron);
    }

    @Test
    public void Patron_defaultConstructorTest() {
        Patron testPatron = new Patron();

        testVariable("firstName",
                testPatron,
                null,
                "When checking the value of firstName we"
        );
        testVariable("lastName",
                testPatron,
                null,
                "When checking the value of lastName we");

        testVariable("phone",
                testPatron,
                null,
                "When checking the value of phone" + " we"
        );
        testVariable("email",
                testPatron,
                null,
                "When checking the value of " + "email we"
        );
        testVariable("pizzas",
                testPatron,
                new ArrayList<>(),
                "When checking the value of " + "pizzas we"
        );

    }

    @Test
    public void Patron_parameterizedConstructorTest() {
        Patron testPatron = new Patron("Caroline", "Budwell", "804-555-1111", "happyDays@vcu.edu");

        testVariable("firstName",
                testPatron,
                "Caroline",
                "When checking the value of " + "firstName we"
        );
        testVariable("lastName",
                testPatron,
                "Budwell",
                "When checking the value of lastName we");

        testVariable("phone",
                testPatron,
                "804-555-1111",
                "When checking the value of " + "phone we"
        );
        testVariable("email",
                testPatron,
                "happyDays@vcu.edu",
                "When checking the value of " + "email we"
        );
        testVariable("pizzas",
                testPatron,
                new ArrayList<>(),
                "When checking the value of " + "pizzas we"
        );

    }

    @Test
    public void Patron_getFirstNameTest() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        Patron testPatron = createPatron("Caroline", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );
        assertEquals(
                "With a Patron object who's name instance variable is `Caroline`, when calling getFirstName we",
                "Caroline",
                testPatron.getFirstName()
        );
    }

    @Test
    public void Patron_setFirstNameTest() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        Patron testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );

        testPatron.setFirstName("Buddy");
        testVariable("firstName",
                testPatron,
                "Buddy",
                "After calling Patron's setFirstName method with an argument of `Buddy`, for the value of firstName we"
        );
    }

    @Test
    public void Patron_getLastName() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        Patron testPatron = createPatron("Buddy", "Sparks", "804-555-1111", "happyDays@vcu.edu", somePizza
        );
        assertEquals(
                "With a Patron object who's lastName instance variable is `Sparks`, when " + "calling getLastName we",
                "Sparks",
                testPatron.getLastName()
        );
    }

    @Test
    public void Patron_setLastName() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        Patron testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );

        testPatron.setLastName("Sparks");
        testVariable("lastName",
                testPatron,
                "Sparks",
                "After calling Patron's setLastName method with an argument of " +
                        "`Sparks`, for the value of lastName we"
        );
    }


    @Test
    public void Patron_getPhone() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        Patron testPatron = createPatron("Buddy", "Budwell", "333-888-1111", "happyDays@vcu.edu", somePizza
        );
        assertEquals(
                "With a Patron object who's phone instance variable is 333-888-1111, " + "when calling getPhone we",
                "333-888-1111",
                testPatron.getPhone()
        );
    }

    @Test
    public void Phone_setPhone() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        Patron testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );

        testPatron.setPhone("333-888-1111");
        testVariable("phone",
                testPatron,
                "333-888-1111",
                "After calling Patron's setPhone method with an argument of " +
                        "`333-888-1111`, for the value of phone we"
        );
    }

    @Test
    public void Patron_getEmail() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        Patron testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );
        assertEquals(
                "With a Patron object who's email instance variable is 203, " + "when"
                        + " calling getEmail we",
                "happyDays@vcu.edu",
                testPatron.getEmail()
        );
    }

    @Test
    public void Patron_setEmail() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        Patron testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );
        testPatron.setEmail("newEmail@vcu.edu");
        testVariable("email",
                testPatron,
                "newEmail@vcu.edu",
                "After calling Patron's setEmail method with an argument of 'newEmail@vcu.edu',"
                        + " for the value of email we"
        );
    }

    @Test
    public void Patron_getNumPizzasTest() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        somePizza.add(createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        ));
        somePizza.add(createPizza(Size.SMALL,
                Crust.HAND_TOSSED,
                Sauce.MARINARA,
                MeatTopping.BACON,
                VeggieTopping.ONIONS
        ));
        Patron testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );
        assertEquals(
                "With a Patron object who's pizzas instance variable has two " +
                        "elements, when calling getNumPizzas we",
                2,
                testPatron.getNumPizzas()
        );
    }

    @Test
    public void Patron_getPizzasTest() {
        ArrayList<Pizza> somePizza = new ArrayList<>();
        somePizza.add(createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        ));
        somePizza.add(createPizza(Size.SMALL,
                Crust.HAND_TOSSED,
                Sauce.MARINARA,
                MeatTopping.BACON,
                VeggieTopping.ONIONS
        ));

        ArrayList<Pizza> expectedPizza = new ArrayList<>();
        expectedPizza.add(createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        ));
        expectedPizza.add(createPizza(Size.SMALL,
                Crust.HAND_TOSSED,
                Sauce.MARINARA,
                MeatTopping.BACON,
                VeggieTopping.ONIONS
        ));
        Patron testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );

        testPizzaArray(
                "With a Patron object who's pizzas instance variable has two " + "elements,"
                        + " when calling getPizzas we",
                expectedPizza,
                testPatron.getPizzas()
        );
    }

    @Test
    public void Patron_addPizzaOnePizzaTest() {
        ArrayList<Pizza> somePizza = new ArrayList<>();

        ArrayList< Pizza> expectedPizza = new ArrayList<>();
        expectedPizza.add(createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        ));
        Patron testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );


        testPatron.addPizza(createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        ));

        testVariable("pizzas",
                testPatron,
                expectedPizza,
                "After a Patron object adds a single pizza, when checking " + "the " + "pizzas instance variable we"
        );

    }

    @Test
    public void Patron_orderPizzasFourPizzaTest() {

        ArrayList<Pizza> expectedPizza = new ArrayList<>();

        expectedPizza.add(createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        ));
        expectedPizza.add(createPizza(Size.SMALL,
                Crust.HAND_TOSSED,
                Sauce.MARINARA,
                MeatTopping.BACON,
                VeggieTopping.ONIONS
        ));
        expectedPizza.add(createPizza(Size.MEDIUM,
                Crust.THIN,
                Sauce.MARINARA,
                MeatTopping.SAUSAGE,
                VeggieTopping.none
        ));
        expectedPizza.add(createPizza(Size.LARGE,
                Crust.THICK,
                Sauce.MARINARA,
                MeatTopping.PEPPERONI,
                VeggieTopping.MUSHROOMS
        ));


        Patron testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", expectedPizza
        );


        testPatron.addPizza(createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        ));
        testPatron.addPizza(createPizza(Size.SMALL,
                Crust.HAND_TOSSED,
                Sauce.MARINARA,
                MeatTopping.BACON,
                VeggieTopping.ONIONS
        ));
        testPatron.addPizza(createPizza(Size.MEDIUM,
                Crust.THIN,
                Sauce.MARINARA,
                MeatTopping.SAUSAGE,
                VeggieTopping.none
        ));
        testPatron.addPizza(createPizza(Size.LARGE,
                Crust.THICK,
                Sauce.MARINARA,
                MeatTopping.PEPPERONI,
                VeggieTopping.MUSHROOMS
        ));


        testVariable("pizzas",
                testPatron,
                expectedPizza,
                "After a Patron object adds four pizzas, when checking " + "the " +
                        "pizzas instance variable " + "we"
        );

    }

    @Test
    public void Patron_toStringTest() {
        ArrayList<Pizza> somePizza = new ArrayList<>();

        Patron testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );

        String expected1 =
                "Buddy\nBudwell\n804-555-1111\nhappyDays@vcu.edu\nPizzas:\n";
        String actual1 = testPatron.toString().replace("\r\n", "\n");
        assertTrue(actual1.contains(expected1));


        somePizza = new ArrayList<>();
        somePizza.add(createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        ));
        somePizza.add(createPizza(Size.SMALL,
                Crust.HAND_TOSSED,
                Sauce.MARINARA,
                MeatTopping.BACON,
                VeggieTopping.ONIONS
        ));
        testPatron = createPatron("Buddy", "Budwell", "804-555-1111", "happyDays@vcu.edu", somePizza
        );

        String expected2 =
                "Buddy\nBudwell\n804-555-1111\nhappyDays@vcu.edu\nPizzas:\n"  + "\n" +
                        "\tPERSONAL\n\tSTUFFED\n\tWHITE\n\tCHICKEN\n\tSPINACH\n" + "\n" +
                        "\tSMALL\n\tHAND_TOSSED\n\tMARINARA\n\tBACON\n\tONIONS\n";
        String actual2 = testPatron.toString().replace("\r\n", "\n");
        assertTrue(actual2.contains(expected2));
    }
    //endregion
    //TODO PizzaTests

    @Test
    public void Pizza_getSize() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );
        assertEquals("When we call getSize on the pizza we",
                expectedPizza.getSize(),
                Size.PERSONAL
        );
    }

    @Test
    public void Pizza_setSize() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );
        expectedPizza.setSize(Size.MEDIUM);
        testVariable("size",
                expectedPizza,
                Size.MEDIUM,
                "When we call setSize with the name Size.MEDIUM we"
        );
    }

    @Test
    public void Pizza_getCrust() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );
        assertEquals("When we call getCrust on the pizza we",
                expectedPizza.getCrust(),
                Crust.STUFFED
        );
    }

    @Test
    public void Pizza_setCrust() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );
        expectedPizza.setCrust(Crust.THICK);
        testVariable("crust",
                expectedPizza,
                Crust.THICK,
                "When we call setCrust with the name Crust.THICK we"
        );
    }

    @Test
    public void Pizza_getSauce() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );
        assertEquals("When we call getSauce on the pizza we",
                expectedPizza.getSauce(),
                Sauce.WHITE
        );
    }

    @Test
    public void Pizza_setSauce() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );
        expectedPizza.setSauce(Sauce.MARINARA);
        testVariable("sauce",
                expectedPizza,
                Sauce.MARINARA,
                "When we call setSauce with the name Sauce.MARINARA we"
        );
    }

    @Test
    public void Pizza_getMeatTopping() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );
        assertEquals("When we call getMeatTopping on the pizza we",
                expectedPizza.getMeatTopping(),
                MeatTopping.CHICKEN
        );
    }

    @Test
    public void Pizza_setMeatTopping() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );
        expectedPizza.setMeatTopping(MeatTopping.HAM);
        testVariable("meatTopping",
                expectedPizza,
                MeatTopping.HAM,
                "When we call setMeatTopping with the name MeatTopping.HAM we"
        );
    }

    @Test
    public void Pizza_getVeggieTopping() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );
        assertEquals("When we call getVeggieTopping on the pizza we",
                expectedPizza.getVeggieTopping(),
                VeggieTopping.SPINACH
        );
    }

    @Test
    public void Pizza_setVeggieTopping() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );
        expectedPizza.setVeggieTopping(VeggieTopping.GREEN_PEPPERS);
        testVariable("veggieTopping",
                expectedPizza,
                VeggieTopping.GREEN_PEPPERS,
                "When we call setVeggieTopping with the name VeggieTopping.GREEN_PEPPERS we"
        );
    }

    @Test
    public void Pizza_toStringTest() {
        Pizza expectedPizza = createPizza(Size.PERSONAL,
                Crust.STUFFED,
                Sauce.WHITE,
                MeatTopping.CHICKEN,
                VeggieTopping.SPINACH
        );

        String expected1 =
                "\n\tPERSONAL\n\tSTUFFED\n\tWHITE\n\tCHICKEN\n\tSPINACH\n";
        String actual1 = expectedPizza.toString().replace("\r\n", "\n");
        assertTrue(actual1.contains(expected1));
    }

    private Patron createPatron(String aFirstName,
                                          String aLastName,
                                          String aPhone,
                                          String anEmail,
                                          ArrayList<Pizza> aPizzas
    ) {
        Patron testPatron = new Patron();
        @SuppressWarnings("rawtypes") Class c = testPatron.getClass();

        try {
            Field firstName = c.getDeclaredField("firstName");
            firstName.setAccessible(true);
            firstName.set(testPatron, aFirstName);

            Field lastName = c.getDeclaredField("lastName");
            lastName.setAccessible(true);
            lastName.set(testPatron, aLastName);

            Field phone = c.getDeclaredField("phone");
            phone.setAccessible(true);
            phone.set(testPatron, aPhone);

            Field email = c.getDeclaredField("email");
            email.setAccessible(true);
            email.set(testPatron, anEmail);

            Field pizzas = c.getDeclaredField("pizzas");
            pizzas.setAccessible(true);
            pizzas.set(testPatron, aPizzas);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testPatron;
    }

    private Pizza createPizza(Size aSize,
                              Crust aCrust,
                              Sauce aSauce,
                              MeatTopping aMeatTopping,
                              VeggieTopping aVeggieTopping
    ) {
        Pizza testPizza = new Pizza();
        @SuppressWarnings("rawtypes") Class c = testPizza.getClass();

        try {
            Field size = c.getDeclaredField("size");
            size.setAccessible(true);
            size.set(testPizza, aSize);

            Field crust = c.getDeclaredField("crust");
            crust.setAccessible(true);
            crust.set(testPizza, aCrust);

            Field sauce = c.getDeclaredField("sauce");
            sauce.setAccessible(true);
            sauce.set(testPizza, aSauce);

            Field meatTopping = c.getDeclaredField("meatTopping");
            meatTopping.setAccessible(true);
            meatTopping.set(testPizza, aMeatTopping);

            Field veggieTopping = c.getDeclaredField("veggieTopping");
            veggieTopping.setAccessible(true);
            veggieTopping.set(testPizza, aVeggieTopping);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testPizza;
    }

    private void instanceVariablePrivate(String aField,
                                         Object testObject
    ) {
        @SuppressWarnings("rawtypes") Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertTrue(String.format("You must make your instance variables private: %s is not " + "private",
                    aField
            ), Modifier.isPrivate(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableStatic(String aField,
                                        Object testObject
    ) {
        @SuppressWarnings("rawtypes") Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("Your instance variables must NOT be static.",
                    false,
                    Modifier.isStatic(c.getDeclaredField(aField).getModifiers())
            );

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableCorrectType(String aField,
                                             Class<?> aClass,
                                             Object testObject
    ) {
        @SuppressWarnings("rawtypes") Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals(
                    "You must make the " + aField + " instance variable of type" + aClass.toString() + ".",
                    aClass,
                    c.getDeclaredField(aField).getType()
            );

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void testVariable(String aField,
                              Object testObject,
                              Object expected,
                              String message
    ) {
        @SuppressWarnings("rawtypes") Class c = testObject.getClass();
        try {
            Field field = c.getDeclaredField(aField);
            field.setAccessible(true);
            Object fieldValue = field.get(testObject);

            if (expected == null) {
                assertNull(message, fieldValue);
            }
            //If class is a double we have a special Junit assert to run
            else if (expected.getClass().equals(Double.class)) {
                double doubleFieldValue = (double) fieldValue;
                double doubleExpected = (double) expected;
                assertEquals(message, doubleExpected, doubleFieldValue, .01);
            }
            //Array of some kind yay
            else if (expected.getClass().isArray()) {

            } else if (expected.getClass().equals(ArrayList.class)) {
                //CUSTOM FOR PROJECT6TESTS!!!
                testPizzaArray(message, (ArrayList) expected, (ArrayList) fieldValue);
            } else {
                assertEquals(message, expected, fieldValue);
            }

        } catch (Exception e) {
            fail(e.toString());
        }
    }

    private void testPizzaArray(String message,
                                ArrayList expected,
                                ArrayList actual
    ) {
        assertEquals(message + " looked at the size and ", expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            if (!PizzaIsEqual(expected.get(i), actual.get(i))) {
                assertEquals(message, expected, actual);
            }
        }
    }

    private boolean PizzaIsEqual(Object o1,
                                 Object o2
    ) {
        @SuppressWarnings("rawtypes") Class c = o1.getClass();
        try {
            Field sizeFieldo1 = c.getDeclaredField("size");
            sizeFieldo1.setAccessible(true);
            Object sizeo1 = sizeFieldo1.get(o1);

            Field sizeFieldo2 = c.getDeclaredField("size");
            sizeFieldo2.setAccessible(true);
            Object sizeo2 = sizeFieldo2.get(o2);

            Field crustFieldo1 = c.getDeclaredField("crust");
            crustFieldo1.setAccessible(true);
            Object crusto1 = crustFieldo1.get(o1);

            Field crustFieldo2 = c.getDeclaredField("crust");
            crustFieldo2.setAccessible(true);
            Object crusto2 = crustFieldo2.get(o2);

            Field sauceFieldo1 = c.getDeclaredField("sauce");
            sauceFieldo1.setAccessible(true);
            Object sauceo1 = sauceFieldo1.get(o1);

            Field sauceFieldo2 = c.getDeclaredField("sauce");
            sauceFieldo2.setAccessible(true);
            Object sauceo2 = sauceFieldo2.get(o2);

            Field meatToppingFieldo1 = c.getDeclaredField("meatTopping");
            meatToppingFieldo1.setAccessible(true);
            Object meatToppingo1 = meatToppingFieldo1.get(o1);

            Field meatToppingFieldo2 = c.getDeclaredField("meatTopping");
            meatToppingFieldo2.setAccessible(true);
            Object meatToppingo2 = meatToppingFieldo2.get(o2);

            Field veggieToppingFieldo1 = c.getDeclaredField("veggieTopping");
            veggieToppingFieldo1.setAccessible(true);
            Object veggieToppingo1 = veggieToppingFieldo1.get(o1);

            Field veggieToppingFieldo2 = c.getDeclaredField("veggieTopping");
            veggieToppingFieldo1.setAccessible(true);
            Object veggieToppingo2 = veggieToppingFieldo1.get(o2);

            if (sizeo1.equals(sizeo2) && crusto1.equals(crusto2) && sauceo1.equals(
                    sauceo2) && meatToppingo1.equals(meatToppingo2) && veggieToppingo1.equals(veggieToppingo2)
            ) {
                return true;
            } else {
                return false;
            }


        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }

        return false;
    }

}
