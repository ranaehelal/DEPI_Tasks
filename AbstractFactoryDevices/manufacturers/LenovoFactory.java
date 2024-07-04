package manufacturers;

import components.Component;
import components.Cpu;
import components.Gpu;
import components.Monitor;

public class LenovoFactory extends ComponentsFactory {
    @Override
    public Component createGpu() {
        return new Gpu("Lenovo");
    }

    @Override
    public Component createCpu() {
        return new Cpu("Lenovo");
    }

    @Override
    public Component createMonitor() {
        return new Monitor("Lenovo");
    }
}
