package controller;

import exception.BadLoginOrPasswordExcepetion;
import model.Administrator;
import model.User;
import model.Forum;

import java.util.LinkedList;

/**
 * Created by wojtek on 06.01.18.
 */
public class SecurityController {
    private Forum forum;

    public SecurityController(Forum forum) {
        this.forum = forum;
    }

    public Boolean register(String nick, String password) {
        if (this.forum.isthisNickFree(nick)) {
            User newUser = new User(nick, password);
            return this.forum.addUser(newUser);
        } else {
            return false;
        }
    }

    public User logIn(String nick, String password) throws BadLoginOrPasswordExcepetion {
        User user = this.forum.getUserByNick(nick);
        if (user instanceof Administrator) user = (Administrator) user;
        if (!user.logIn(password)) throw new BadLoginOrPasswordExcepetion();
        return user;
    }

    public Boolean isLoggedIn(User user) {
        return user.isLoggedIn();
    }
}
