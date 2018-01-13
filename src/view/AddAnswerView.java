package view;

import controller.ForumController;
import model.Answer;

import java.util.Scanner;

/**
 * Created by wojtek on 13.01.18.
 */
public class AddAnswerView {
    private ForumController forumController;
    private Scanner in;

    public AddAnswerView(ForumController forumController, Scanner in) {
        this.forumController = forumController;
        this.in = in;
    }

    public void addAnswerView() {
        String descriptionOfAnswer;
        System.out.println("Wpisz odpowiedz!");
        descriptionOfAnswer = in.nextLine();
        this.forumController.getCurrentThread().addAnswer(
                new Answer(this.forumController.getLoggedUser(), descriptionOfAnswer));
        System.out.println("Dodano odpowiedz!");
    }
}
