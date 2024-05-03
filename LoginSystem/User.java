abstract public class User {
    protected  String username;
    protected String password;
    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean CheckAuthenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public abstract void displayMenu();

    // public bool CheckAuthentication (list <>)
}
