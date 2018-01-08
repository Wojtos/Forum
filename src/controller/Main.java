package controller;

import model.Forum;
import view.*;

/**
 * Created by wojtek on 07.01.18.
 */
public class Main {

    public static void main(String[] args) {
        Forum forum = new Forum();
        SecurityController securityController = new SecurityController(forum);
        Start start = new Start(securityController);
        if (!start.startView()) Main.quit();
        ForumController forumController = new ForumController(forum, securityController.getUser());
        Home home = new Home(forumController);
        if (!home.HomeView()) Main.quit();
    }

    public static void quit() {

    }
}
