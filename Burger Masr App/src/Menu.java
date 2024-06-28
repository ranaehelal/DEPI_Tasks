import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Sandwich> sandwiches;

    public Menu() {
        sandwiches = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }
    public void removeSandwich(String name){
        sandwiches.removeIf(sandwich -> sandwich.getName().equalsIgnoreCase(name));


    }
    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void displayMenu() {
        System.out.println("Menu:");
        int index = 1;
        for (Sandwich sandwich : sandwiches) {
            System.out.println(index++ + ". " + sandwich.getName() + " - " + sandwich.getPrice());
        }
    }
}
