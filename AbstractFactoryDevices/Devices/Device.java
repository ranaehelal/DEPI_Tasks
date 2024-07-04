package Devices;

import components.Component;

public abstract class Device {
    protected Component cpu;
    protected Component gpu;
    protected Component monitor;

    public Device(Component cpu, Component gpu, Component monitor) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.monitor = monitor;
    }

    public abstract void build();
}
