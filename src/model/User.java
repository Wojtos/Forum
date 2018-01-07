package model;

/**
 * Created by wojtek on 06.01.18.
 */
public class User {
    private String nick;
    private String password;
    private Boolean loggedIn;

    public User(String nick, String password) {
        this.nick = nick;
        this.password = password;
        this.loggedIn = false;
    }

    public Boolean logIn(String password) {
        this.loggedIn = this.password.equals(password);
        return this.loggedIn;
    }

    public void logOut() {
        this.loggedIn = false;
    }

    public String getNick() {
        return this.nick;
    }

    public Boolean isLoggedIn() {return this.loggedIn;}

    private String getPassword() {
        return this.password;
    }

}
