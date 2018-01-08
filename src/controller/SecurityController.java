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
    private User user;

    public SecurityController(Forum forum) {
        this.forum = forum;
        this.user = null;
    }

    public Boolean register(String nick, String password) {
        if (this.forum.isthisNickFree(nick)) {
            this.user = new User(nick, password);
            return this.forum.addUser(this.user);
        } else {
            return false;
        }
    }

    public Boolean registerAdministrator(String nick, String password) {
        if (this.forum.isthisNickFree(nick)) {
            Administrator newAdministrator = new Administrator(nick, password);
            return this.forum.addUser(newAdministrator);
        } else {
            return false;
        }
    }

    public Boolean logIn(String nick, String password) throws BadLoginOrPasswordExcepetion {
        User user = this.forum.getUserByNick(nick);
        if (!user.logIn(password)) throw new BadLoginOrPasswordExcepetion();
        else this.user = user;
        return true;
    }

    public Boolean isLoggedIn() {
        return this.user != null;
    }

    public Boolean isItAdministrator() {
        return this.user instanceof Administrator;
    }

    protected User getUser(){ return this.user; }


}
