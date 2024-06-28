import java.util.ArrayList;

public class BurgerMasrApp {
    public static void main(String[] args) {
        Menu menu = new Menu();
        AdditionsMenu additions = new AdditionsMenu();


        // Pre-populate with some data
        menu.addSandwich(new Sandwich("Beef Burger", 80));
        menu.addSandwich(new Sandwich("Chicken Burger", 70));
        menu.addSandwich(new Sandwich("Cheese Burger", 95));

        additions.addAddition(new Addition("Ketchup", 5));
        additions.addAddition(new Addition("Mayonnaise", 10));
        additions.addAddition(new Addition("Tomatoes", 5));
        additions.addAddition(new Addition("Cheese", 15));

        UserMain userMain = new UserMain(menu, additions);
        AdminMain adminMain = new AdminMain(menu, additions);
        //-------------------------------------

        ArrayList<RegularUser> regularUsers = new ArrayList<>();
        ArrayList<Admin> admins = new ArrayList<>();

        // Example users
        regularUsers.add(new RegularUser("user1", "password1"));
        admins.add(new Admin("admin1", "admin123"));


        Login auth = new Login(regularUsers, admins);


        User loggedInUser = auth.loginProcess();

        if (loggedInUser != null) {
            if (loggedInUser instanceof Admin) {
                System.out.println("Welcome Admin: " + loggedInUser.getUsername());

                adminMain.manageMenu();
            } else if (loggedInUser instanceof RegularUser) {
                System.out.println("Welcome User: " + loggedInUser.getUsername());

                userMain.placeOrder();

            }
        } else {
            System.out.println("Exiting the application.");
        }
    }
    }

