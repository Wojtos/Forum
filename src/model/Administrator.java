package model;

import java.io.Serializable;

/**
 * Created by wojtek on 06.01.18.
 */
public class Administrator extends User {
    public Administrator(String nick, String password){
        super(nick, password);
    }

    public Boolean changeUserPassword(User user, String newPassword) {
        return user.changePassword(user.password, newPassword);
    }
}
