package dvanol;

public class Cookies extends Sweets {
    private String country;

    public Cookies(String name, double massa, double price, String sName, String country) {
        super(name, massa, price, sName);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
    @Override
    public String toString() {
        return "Наименование: " + getName() +
                ", масса: " + getMassa() +
                ", стоимость: " + getPrice() + " " +
                getsName() +
                ": " + getCountry();
    }
}
