package view;

import controller.ForumController;
import model.Answer;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by wojtek on 13.01.18.
 */
public class ThreadView {
    private ForumController forumController;
    private Scanner in;

    public ThreadView(ForumController forumController, Scanner in) {
        this.forumController = forumController;
        this.in = in;
    }

    public boolean threadView() {
        do {
            this.forumController.getCurrentThread().printThread();

            LinkedList<Answer> answers = this.forumController.getCurrentThread().getAnswers();
            System.out.println("Naciśnij A, aby dodać opowiedź!");
            int i = 0;
            if (this.forumController.getLoggedUser().isItAdministrator()) {
                for (Answer answer : answers) {
                    System.out.println("Naciśnij " + i + ", aby usunąć odpowiedź nr." + i + " o nazwie: " + answer.getAnswer());
                    i++;
                }
            }
            System.out.println("Naciśnij B, aby się cofnąć!");
            System.out.println("Naciśnij Q, aby wyjść!");


            String inputChar;
            int numberOfAnswer;

            try {

                inputChar = in.nextLine();
                if (inputChar.equals("Q") || inputChar.equals("q")) {
                    return false;
                } else if (inputChar.equals("B") || inputChar.equals("b")) {
                    return true;
                } else if (inputChar.equals("A") || inputChar.equals("a")) {
                    AddAnswerView addAnswerView = new AddAnswerView(forumController, in);
                    addAnswerView.addAnswerView();
                } else if (this.forumController.getLoggedUser().isItAdministrator()) {
                    numberOfAnswer = Integer.parseInt(inputChar);
                    this.forumController.getCurrentThread().deleteAnswer(numberOfAnswer);
                    System.out.println("Usunieto odpowiedz!");

                } else {
                    System.out.println("Wpisz odpowiedni znak!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wpisz odpowiedni znak!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nie ma takiego wątku!");
            }

        } while(true);

    }
}
