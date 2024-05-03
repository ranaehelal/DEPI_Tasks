public class Student extends User{
    public Student(String username, String password){
        super(username,password);
    }

    @Override
    public void displayMenu() {
        System.out.println("Login successful! list of Courses ");
        System.out.println("- Java Programming ");
        System.out.println("- Web Development ");
        System.out.println("- Data Science ");
        System.out.println("- Machine Language  ");
    }
}
