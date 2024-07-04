package manufacturers;

import components.*;


public class DellFactory extends ComponentsFactory {
    @Override
    public Component createGpu() {
        return new Gpu("Dell");
    }
    @Override
    public Component createCpu() {
        return new Cpu("Dell");
    }
    @Override
    public Component createMonitor() {
        return new Monitor("Dell");
    }

}
