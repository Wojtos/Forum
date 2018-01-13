package controller;

import model.*;
import model.Thread;

import java.util.*;

/**
 * Created by wojtek on 06.01.18.
 */
public class ForumController {
    private Forum forum;
    private User loggedUser;
    protected Thread currentThread;

    public ForumController(Forum forum, User loggedUser) {
        this.forum = forum;
        this.loggedUser = loggedUser;
        this.currentThread = null;
    }

    public Boolean addThread(String name, String description) {
        Thread thread = new Thread(this.loggedUser, name, description);
        return this.forum.addThread(thread);
    }


    public Thread goToThread(int number) throws IndexOutOfBoundsException {
        this.currentThread = this.forum.getThread(number);
        return this.currentThread;
    }


    public Forum getForum() {
        return this.forum;
    }

    public User getLoggedUser() {
        return this.loggedUser;
    }

    public Thread getCurrentThread() {
        return this.currentThread;
    }
}
