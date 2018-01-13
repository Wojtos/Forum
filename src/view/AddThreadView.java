package view;

import controller.ForumController;

import java.util.Scanner;

/**
 * Created by wojtek on 13.01.18.
 */
public class AddThreadView {
    private ForumController forumController;
    private Scanner in;

    public AddThreadView(ForumController forumController, Scanner in) {
        this.forumController = forumController;
        this.in = in;
    }

    public void addThreadView() {
        String nameOfThread;
        String descriptionOfThread;
        System.out.println("Wpisz nazwę wątku!");
        nameOfThread = in.nextLine();
        System.out.println("Wpisz opis wątku!");
        descriptionOfThread = in.nextLine();
        this.forumController.addThread(nameOfThread, descriptionOfThread);
        System.out.println("Dodano wątek!");
    }
}
