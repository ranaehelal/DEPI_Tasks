package components;

public class Gpu implements Component {
    private String manufacturer;

    public Gpu(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void run() {
        System.out.println("GPU from: " + manufacturer);
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
