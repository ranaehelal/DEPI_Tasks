import java.util.List;
import java.util.Scanner;

public class Order {
    private Scanner scanner;

    private Sandwich sandwich;
    private List<Addition> additions;
    private UserMain userMain; // Reference to UserMain


    public Order(Sandwich sandwich, List<Addition> additions, UserMain userMain) {
        this.sandwich = sandwich;
        this.additions = additions;


        this.userMain = userMain; // Initialize the UserMain reference

        this.scanner = new Scanner(System.in); // Initialize the scanner

    }

    public double calculateTotal() {
        double total = sandwich.getPrice();
        for (Addition addition : additions) {
            total += addition.getPrice();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("Receipt:");
        System.out.println("1 " + sandwich.getName() + " " + sandwich.getPrice());
        for (Addition addition : additions) {
            System.out.println("1 Extra " + addition.getName() + " " + addition.getPrice());
        }
        System.out.println("Total: " + calculateTotal());
        System.out.println("Order has been confirmed.");

        System.out.println("1-Back to Menu");
        System.out.println("2-Exit");
        int choice = scanner.nextInt();
        if (choice==1){
            //return to menu to place order
            userMain.placeOrder();

        }

    }
}
