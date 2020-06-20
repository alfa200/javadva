package dvanol;

public class Jellybean extends Sweets {
    private String color;

    public Jellybean(String name, double massa, double price, String sName, String color) {
        super(name, massa, price, sName);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    @Override
    public String toString() {
        return "Наименование: " + getName() +
                ", масса: " + getMassa() +
                ", стоимость: " + getPrice() + " " +
                getsName() +
                ": " + getColor();
    }
}
