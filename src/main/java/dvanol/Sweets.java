package dvanol;

public abstract class Sweets {
    private String name;
    private double massa;
    private double price;
    private String sName;

    public Sweets(String name, double massa, double price, String sName) {
        this.name = name;
        this.massa = massa;
        this.price = price;
        this.sName = sName;
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

    public String getsName() {
        return sName;
    }

}
