package components;

public class Cpu implements Component {
    private String manufacturer;

    public Cpu(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void run() {
        System.out.println("CPU from: " + manufacturer);
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
