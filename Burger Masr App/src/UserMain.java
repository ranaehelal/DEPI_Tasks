import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserMain {
    private Scanner scanner;

    private Menu menu;
    private AdditionsMenu additions;

    public UserMain(Menu menu, AdditionsMenu additions) {
        this.menu=menu;
        this.additions=additions;
        this.scanner = new Scanner(System.in); // Initialize the scanner


    }

    public void placeOrder(){
        menu.displayMenu();
        System.out.println("Please select option:");
        int sandwichOption = scanner.nextInt();//get sandwich from array
        Sandwich sandwich = menu.getSandwiches().get(sandwichOption - 1);


        System.out.println("Do you like to add any additions?");
        System.out.println("1- Yes");
        System.out.println("2- No");
        int additionOption = scanner.nextInt();

        List<Addition> selectedAdditions = new ArrayList<>();
        if (additionOption == 1) {
            additions.displayMenu();
            System.out.println("Please select options (like this 1,2):");
            scanner.nextLine(); // Consume newline
            String[] additionOptions = scanner.nextLine().split(",");
            for (String option : additionOptions) {  //convert it to int
                selectedAdditions.add(additions.getAdditions().get(Integer.parseInt(option.trim()) - 1));
            }
        }
        System.out.println("Your order is :");
        System.out.print(sandwich.getName());
        for (Addition addition : selectedAdditions) {
            System.out.print(" Extra "+addition.getName());

        }
        System.out.println("");

        System.out.println("1-Confirm order: (Y/N)");
        System.out.println("2-Back to Menu");

        int choice = scanner.nextInt();

        if (choice==1) {
            String addConfirm = scanner.next();
            if (addConfirm.equalsIgnoreCase("y")) {
                Order order = new Order(sandwich, selectedAdditions,this);
                order.printReceipt();
            } else {
                System.out.println("Order cancelled.");
                System.out.println("1-Back to Menu");
                System.out.println("2-Exit");
                int choice2 = scanner.nextInt();
                if (choice2==1){
                    //return to menu to place order
                    placeOrder();

                }
            }
        }
        else if (choice==2){
            //return to main menu to place order
            placeOrder();


        }

    }
}
