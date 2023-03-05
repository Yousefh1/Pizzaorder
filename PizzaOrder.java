/// Youssouf Hassan

import java.util.Scanner;

class PizzaOrder{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstName = "";
        boolean discount = false;
        double cost = 12.99;

        // Prompt user for their first name
        System.out.print("Please enter your first name: ");
        firstName = input.nextLine();

        // Check if user is eligible for discount
        if (firstName.equalsIgnoreCase("Mike") || firstName.equalsIgnoreCase("Diane")) {
            discount = true;
        }

        // Prompt user for pizza size
        System.out.println("What size pizza would you like? (10, 12, 14, or 16 inches)");
        int size = input.nextInt();

        // Determine cost based on size
        if (size == 10) {
            cost += 9.99;
        } else if (size == 12) {
            cost += 12.99;
        } else if (size == 14) {
            cost += 14.99;
        } else if (size == 16) {
            cost += 16.99;
        } else {
            System.out.println("Invalid size entered, defaulting to 12 inch pizza.");
        }

        // Prompt user for crust type
        System.out.println("What type of crust would you like?");
        System.out.println("Enter H for Hand-tossed, T for Thin, or D for Deep-dish.");
        char crustType = input.next().charAt(0);

        // Assign appropriate crust type based on user input
        String crust = "";
        switch (crustType) {
            case 'H':
            case 'h':
                crust = "Hand-tossed";
                break;
            case 'T':
            case 't':
                crust = "Thin";
                cost += 1.99;
                break;
            case 'D':
            case 'd':
                crust = "Deep-dish";
                cost += 2.99;
                break;
            default:
                System.out.println("Invalid crust type entered, defaulting to Hand-tossed.");
                crust = "Hand-tossed";
                break;
        }

        // Add cost of toppings
        System.out.println("Would you like to add toppings? (Y/N)");
        char addToppings = input.next().charAt(0);
        if (addToppings == 'Y' || addToppings == 'y') {
            System.out.println("Toppings cost $0.99 each. Enter the number of toppings you would like:");
            int numToppings = input.nextInt();
            cost += numToppings * 0.99;
        }

        // Apply discount if eligible
        if (discount) {
            cost -= 2.00;
            System.out.println("Congratulations, you received a $2.00 discount for being a loyal customer!");
        }

        // Print final order details and cost
        System.out.println("Your " + size + " inch " + crust + " pizza order is ready!");
        System.out.println("Total cost: $" + String.format("%.2f", cost));
    }
}
