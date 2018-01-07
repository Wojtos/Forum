package model;

import java.util.LinkedList;
import exception.BadLoginOrPasswordExcepetion;

/**
 * Created by wojtek on 06.01.18.
 */
public class Forum {

    private LinkedList<User> users;


    public Forum() {
        users = new LinkedList<>();
        Administrator admin = new Administrator("admin","admin");
        this.addUser(admin);

    }

    public Boolean isthisNickFree(String nick) {
        for (User user: users) {
            if (user.getNick().equals(nick)) return false;
        }
        return true;

    }

    public User getUserByNick(String nick) throws BadLoginOrPasswordExcepetion{
        for (User user: users) {
            if (user.getNick().equals(nick)) return user;
        }
        throw new BadLoginOrPasswordExcepetion();
    }

    public Boolean addUser(User newUser) {
         return this.users.add(newUser);
    }

}
