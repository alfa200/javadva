package dvanol;

public class BagOfSweets {
    
    private String name;
    private double massa;
    private double price;
    private String specialPart;

    public BagOfSweets(String name, double mass, double price, String specialPart) {
        this.name = name;
        this.massa = mass;
        this.price = price;
        this.specialPart = specialPart;
    }

    public String getName() {
        return name;
    }

    public double getMassa() {
        return massa;
    }

    public double getPrice() {
        return price;
    }

    public String getSpecialPart() {
        return specialPart;
    }
}
