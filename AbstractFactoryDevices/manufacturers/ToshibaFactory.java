package manufacturers;

import components.*;

public class ToshibaFactory extends ComponentsFactory {
    @Override
    public Component createGpu() {
        return new Gpu("Toshiba");
    }

    @Override
    public Component createCpu() {
        return new Cpu("Toshiba");
    }

    @Override
    public Component createMonitor() {
        return new Monitor("Toshiba");
    }
}
