
import java.util.ArrayList;
import java.util.Scanner;
public class Login {
    private ArrayList<RegularUser> regularUsers;
    private ArrayList<Admin> admins;
    private Scanner scanner;

    public Login(ArrayList<RegularUser> regularUsers, ArrayList<Admin> admins) {
        this.regularUsers = regularUsers;
        this.admins = admins;
        this.scanner = new Scanner(System.in);
    }
    public User loginProcess() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        for (RegularUser regularUser : regularUsers) {
            if (regularUser.checkAuthenticate(username, password)) {
                System.out.println("Login successful!");
                return regularUser;
            }
        }

        for (Admin admin : admins) {
            if (admin.checkAuthenticate(username, password)) {
                System.out.println("Login successful!");
                return admin;
            }
        }

        System.out.println("Invalid username or password.");
        return null;
    }
}
