package model;

import java.io.Serializable;

/**
 * Created by wojtek on 06.01.18.
 */
public class User implements Serializable {
    protected String nick;
    protected String password;

    public User(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public Boolean logIn(String password) {
        return this.password.equals(password);
    }

    public String getNick() {
        return this.nick;
    }

    public Boolean changePassword(String oldPassword, String newPassword) {
        if (!this.password.equals(oldPassword)) return false;
        this.password = newPassword;
        return true;
    }

    public Boolean isItAdministrator() {
        return this instanceof Administrator;
    }


}
