package nwscbilling;

public class customer {

    private double consumption;
    private String band;
    private double rate;
    private double serviceCharge;
    private double totalBill;

    // Constructor
    public customer(double consumption) {
        this.consumption = consumption;
        calculateBill();
    }

    // Method to calculate the bill
    private void calculateBill() {

        if (consumption >= 0 && consumption <= 5) {
            band = "LIFELINE";
            rate = 1000;
            serviceCharge = 2000;

        } else if (consumption > 5 && consumption <= 20) {
            band = "DOMESTIC LOW";
            rate = 2500;
            serviceCharge = 4000;

        } else if (consumption > 20 && consumption <= 50) {
            band = "DOMESTIC HIGH";
            rate = 3800;
            serviceCharge = 7500;

        } else if (consumption > 50 && consumption <= 100) {
            band = "COMMERCIAL";
            rate = 4500;
            serviceCharge = 15000;

        } else if (consumption > 100 && consumption <= 300) {
            band = "INDUSTRIAL";
            rate = 5200;
            serviceCharge = 40000;

        } else if (consumption > 300) {
            band = "INSTITUTIONAL";
            rate = 6000;
            serviceCharge = 90000;
            
        } else {
            // Handle negative consumption
            band = "INVALID";
            rate = 0;
            serviceCharge = 0;
            totalBill = 0;
            return;
        }

        totalBill = (consumption * rate) + serviceCharge;
    }

    public double getConsumption() {
        return consumption;
    }

    public String getBand() {
        return band;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void displayCustomer() {
        System.out.println("\n----- Customer Details -----");
        System.out.println("Consumption: " + consumption + " m3");
        System.out.println("Band: " + band);
        System.out.println("Total Bill: UGX " + totalBill);
    }
}