import Devices.*;
import components.*;
import manufacturers.*;

public class CratePcMain {
    public static void main(String[] args) {
        // Create manufacturers
        ComponentsFactory dellFactory = new DellFactory();
        ComponentsFactory lenovoFactory = new LenovoFactory();
        ComponentsFactory toshibaFactory = new ToshibaFactory();

        //create components
        Component dellCpu = dellFactory.createCpu();
        Component lenovoGpu = lenovoFactory.createGpu();
        Component toshibaMonitor = toshibaFactory.createMonitor();

        // Create a PCs.PC with components from many manufacturers
        Device customPC = new PC(dellCpu, lenovoGpu, toshibaMonitor);
        customPC.build();



    }
}


// component gpu , cpu , monitor]
// manufacturers lenovo ,toshiba,Dell

