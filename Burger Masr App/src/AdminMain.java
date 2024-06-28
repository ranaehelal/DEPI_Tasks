import java.util.Scanner;

public class AdminMain {
    private Menu menu;
    private AdditionsMenu additions;
    private Scanner scanner;

    public AdminMain(Menu menu, AdditionsMenu additions) {
        this.menu=menu;
        this.additions=additions;
        this.scanner = new Scanner(System.in); // Initialize the scanner


    }

    public void manageMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("1- View Menu");
            System.out.println("2- View Additions");
            System.out.println("3- Add New Item to Menu");
            System.out.println("4- Add New Addition");
            System.out.println("5- Delete Item from Menu");
            System.out.println("6- Delete Addition ");
            System.out.println("7- Exist");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline


            switch (option) {
                case 1:
                    menu.displayMenu();
                    System.out.println("");
                    break;
                case 2:
                    additions.displayMenu();
                    System.out.println("");

                    break;

                case 3:
                    System.out.println("Enter name:");
                    String newItemName = scanner.nextLine();
                    System.out.println("Enter price:");
                    double newItemPrice = scanner.nextDouble();
                    System.out.println("Confirm: (Y/N)");
                    String addConfirm = scanner.next();
                    if (addConfirm.equalsIgnoreCase("y")) {
                        menu.addSandwich(new Sandwich(newItemName, newItemPrice));
                        System.out.println("Sandwich added to the menu.");
                    } else {
                        System.out.println("Operation cancelled. Sandwich not added.");
                    }
                    break;
                case 4:
                    System.out.println("Enter name:");
                    String newAddName = scanner.nextLine();
                    System.out.println("Enter price:");
                    double newAddPrice = scanner.nextDouble();
                    System.out.println("Confirm: (Y/N)");
                    String addConfirm2 = scanner.next();
                    if (addConfirm2.equalsIgnoreCase("y")) {
                        additions.addAddition(new Addition(newAddName, newAddPrice));
                        System.out.println("Addition added.");
                    } else {
                        System.out.println("Operation cancelled. Addition not added.");
                    }
                    break;
                case 5:
                    System.out.println("Enter name:");
                    String itemRemovedName =scanner.nextLine();
                    menu.removeSandwich(itemRemovedName);
                    break;


                case 6:
                    System.out.println("Enter name:");
                    String additionRemovedName = scanner.nextLine();
                    additions.removeAddition(additionRemovedName);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option");
                    break;


            }
        }

    }

}
