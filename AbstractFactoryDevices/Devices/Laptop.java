package Devices;

import components.Component;

public class Laptop extends Device {

    public Laptop(Component cpu, Component gpu, Component monitor) {
        super(cpu, gpu, monitor);
    }

    @Override
    public void build() {
        System.out.println("Laptop components are:");
        cpu.run();
        gpu.run();
        monitor.run();
    }
}
