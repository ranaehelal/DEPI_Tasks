import java.util.ArrayList;
import java.util.List;

public class AdditionsMenu {
    private List<Addition> additions;

    public AdditionsMenu() {
        additions = new ArrayList<>();
    }

    public void addAddition(Addition addition) {
        additions.add(addition);
    }
    public void removeAddition(String name){
        additions.removeIf(addition -> addition.getName().equalsIgnoreCase(name));


    }

    public List<Addition> getAdditions() {
        return additions;
    }

    public void displayMenu() {
        System.out.println("Additions:");
        int index = 1;
        for (Addition addition : additions) {
            System.out.println(index++ + ". " + addition.getName() + " - " + addition.getPrice());
        }
    }


}
