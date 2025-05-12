public class Car {
    public String  make;
    public String  model;
    public String  color;
    public double price;
    public String availability;
    // "IN STOCK", "DEALER TRADE", "FACTORY ORDER"

    public Car(String make, String model, String color, double price, String availability){
        this.make = make;
        this.model = model;
        this.color = color;
        this.price = price;
        this.availability = availability;
        // "IN STOCK", "DEALER TRADE", "FACTORY ORDER"
    }

    public String toString(){
        String extraTab = (this.color.equals("Red")? "\t" : "");
        return make + "\t" + model + "\t" + color + extraTab + "\t$" + price + "\t: " + availability;
    }

    public static void main(String[] args) {
        System.out.println("Car class working");
    }
}
