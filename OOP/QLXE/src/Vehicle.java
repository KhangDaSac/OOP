public class Vehicle {
    private String ownerName;
    private String type;
    private int dungtich;
    private double price;

    public Vehicle(String ownerName, String type, int dungtich, double price) {
        this.ownerName = ownerName;
        this.type = type;
        this.dungtich = dungtich;
        this.price = price;
    }

    public Vehicle() {
        this("No name", "No type", 0, 0);

    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDungtich() {
        return dungtich;
    }

    public void setDungtich(int dungtich) {
        this.dungtich = dungtich;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double tax() {
        if (dungtich < 100)
            return price*0.01;
        else if (dungtich < 200)
            return price*0.03;
        else return price*0.05;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-10d %-20.2f %-15.2f", ownerName, type, dungtich, price, tax());
    }
}
