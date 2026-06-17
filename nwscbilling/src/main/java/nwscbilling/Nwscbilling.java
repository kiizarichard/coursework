package nwscbilling;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Nwscbilling {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<customer> customers = new ArrayList<>();

        int lifeline = 0;
        int domesticLow = 0;
        int domesticHigh = 0;
        int commercial = 0;
        int industrial = 0;
        int institutional = 0;

        double totalRevenue = 0;

        System.out.println("===== NWSC BILLING SYSTEM =====");

        // Process 6 customers
        for (int i = 1; i <= 6; i++) {

            double consumption = 0;

            while (true) {

                try {

                    System.out.print("\nEnter water consumption for customer "
                            + i + " (m3): ");

                    consumption = input.nextDouble();

                    if (consumption < 0) {

                        System.out.println(
                                "Consumption cannot be negative.");

                    } else {

                        break;
                    }

                } catch (InputMismatchException e) {

                    System.out.println(
                            "Invalid input. Please enter numbers only.");

                    input.next(); // clear invalid input
                }
            }

            customer customer = new customer(consumption);

            customers.add(customer);

            customer.displayCustomer();

            totalRevenue += customer.getTotalBill();

            switch (customer.getBand()) {

                case "LIFELINE":
                    lifeline++;
                    break;

                case "DOMESTIC LOW":
                    domesticLow++;
                    break;

                case "DOMESTIC HIGH":
                    domesticHigh++;
                    break;

                case "COMMERCIAL":
                    commercial++;
                    break;

                case "INDUSTRIAL":
                    industrial++;
                    break;

                case "INSTITUTIONAL":
                    institutional++;
                    break;
            }
        }

        double averageBill = totalRevenue / customers.size();

        // Billing summary
        System.out.println("\n===== BILLING SUMMARY =====");

        System.out.println("LIFELINE: " + lifeline);

        System.out.println("DOMESTIC LOW: " + domesticLow);

        System.out.println("DOMESTIC HIGH: " + domesticHigh);

        System.out.println("COMMERCIAL: " + commercial);

        System.out.println("INDUSTRIAL: " + industrial);

        System.out.println("INSTITUTIONAL: " + institutional);

        System.out.println("\nTotal Revenue: UGX " + totalRevenue);

        System.out.println("Average Bill: UGX " + averageBill);

        input.close();
    }
}