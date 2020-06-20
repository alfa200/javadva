package dvanol;

public class Candy extends Sweets {

    private String flavor;

    public Candy(String name, double massa, double price, String sName, String flavor) {
        super(name, massa, price, sName);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return "Наименование: " + getName() +
                ", масса: " + getMassa() +
                ", стоимость: " + getPrice() + " " +
                getsName() +
                ": " + getFlavor();
    }
}
