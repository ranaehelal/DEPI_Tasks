package components;

public class Monitor implements Component {

    private String manufacturer;

    public Monitor(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void run() {
        System.out.println("Monitor from: " + manufacturer);
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
