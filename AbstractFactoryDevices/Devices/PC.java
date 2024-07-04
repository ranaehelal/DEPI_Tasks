package Devices;

import components.Component;

public class PC extends Device {

    public PC(Component cpu, Component gpu, Component monitor) {
        super(cpu, gpu, monitor);
    }

    @Override
    public void build() {
        System.out.println("PC components are:");
        cpu.run();
        gpu.run();
        monitor.run();
    }
}

