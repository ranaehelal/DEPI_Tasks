public class Instructor extends User{

    public Instructor(String username, String password){
        super(username,password);
    }
    @Override
    public void displayMenu() {
        System.out.println("Login successful! List od Students:");
        System.out.println("- Student 1");
        System.out.println("- Student 2");
        System.out.println("- Student 3");
        System.out.println("- Student 4");
    }
}
