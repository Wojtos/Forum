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

    public Boolean addAnswer(String description) {
        if (this.currentThread == null) return false;
        Answer answer = new Answer(loggedUser, description);
        return this.currentThread.addAnswer(answer);
    }

    public Boolean deleteThread(int number) throws IndexOutOfBoundsException{
        if (!(loggedUser instanceof Administrator)) return false;
        this.forum.deleteThread(number);
        return true;
    }

    public LinkedList<Thread> getAllThreads() {
        return this.forum.getThreads();
    }

    public int getNumberOfThreads() {
        return this.forum.getThreads().size();
    }

    public int getNumberOfAnswers() {
        return this.currentThread.getAnswers().size();
    }

    public Boolean getThread(int number) throws IndexOutOfBoundsException {
        this.currentThread = this.forum.getThread(number);
        return true;
    }

    public Boolean deleteAnswer(int number) throws IndexOutOfBoundsException{
        return this.currentThread.deleteAnswer(number);
    }

    public void printForum() {
        this.forum.printForum();
    }

    public void printThread() {
        this.currentThread.printThread();
    }

    public Boolean isUserAdministrator() {
        return this.loggedUser instanceof Administrator;
    }
}
