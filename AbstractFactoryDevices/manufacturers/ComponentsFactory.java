package manufacturers;

import components.Component;

public abstract class ComponentsFactory {
    public  abstract Component createGpu();

    public abstract Component createCpu();

    public abstract Component createMonitor();
}
