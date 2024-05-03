import java.util.ArrayList;
import java.util.Scanner;
public class LoginApp {
    ArrayList<Instructor> Instructors = new ArrayList<>();
    ArrayList<Student> Students = new ArrayList<>();
;
    public LoginApp() {
        Instructors.add(new Instructor("instructor1", "instpass1"));
        Instructors.add(new Instructor("instructor2", "instpass2"));
        Instructors.add(new Instructor("instructor3", "instpass3"));
        Instructors.add(new Instructor("instructor4", "instpass4"));

        Students.add(new Student("student1", "stupass1"));
        Students.add(new Student("student2", "stupass2"));
        Students.add(new Student("student3", "stupass3"));
        Students.add(new Student("student4", "stupass4"));
    }
    public void Run(){
        Scanner myObj = new Scanner(System.in);

        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("Enter username: ");
            String username = myObj.nextLine();
            System.out.println("Enter password: ");
            String password = myObj.nextLine();
            if (username.charAt(0) == 'i') {  // Instructor login
                for (Instructor instructor : Instructors) {
                    if (instructor.CheckAuthenticate(username, password)) {
                        instructor.displayMenu();
                        isLoggedIn = true;
                        break;
                    }
                }
            } else if (username.charAt(0) == 's') {  // Student login
                for (Student student : Students) {
                    if (student.CheckAuthenticate(username, password)) {
                        student.displayMenu();
                        isLoggedIn = true;
                        break;
                    }
                }
            }
            if (!isLoggedIn) {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }


  }

