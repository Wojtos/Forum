package view;

import controller.ForumController;
import exception.BadLoginOrPasswordExcepetion;
import model.Thread;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by wojtek on 07.01.18.
 */
public class Home {
    private ForumController forumController;

    public Home(ForumController forumController) {
        this.forumController = forumController;
    }

    public Boolean HomeView() {
        Scanner in = new Scanner(System.in);
        boolean continueView;
        do {
            this.forumController.printForum();
            int numberOfThreads = this.forumController.getNumberOfThreads();
            for (int i = 0; i < numberOfThreads; i++) {
                System.out.println("Naciśnij " + i  +", aby wejść do wątku nr." + i);
            }
            System.out.println("Naciśnij D, aby się dodać wątek!");
            if (this.forumController.isUserAdministrator())
                System.out.println("Naciśnij U, aby przejść do usuwania wątków!");
            System.out.println("Naciśnij Q, aby wyjść!");

            String inputChar;
            int numberOfThread;
            String nameOfThread;
            String descriptionOfThread;

            continueView = true;

            try {

                inputChar = in.nextLine();
                if (inputChar.equals("Q") || inputChar.equals("q")) {
                    return false;
                } else if (this.forumController.isUserAdministrator() &&
                        (inputChar.equals("U") || inputChar.equals("u"))) {
                    continueView = this.deleteThreadView();
                } else if (inputChar.equals("D") || inputChar.equals("d")) {
                    System.out.println("Wpisz nazwę wątku!");
                    nameOfThread = in.nextLine();
                    System.out.println("Wpisz opis wątku!");
                    descriptionOfThread = in.nextLine();
                    this.forumController.addThread(nameOfThread, descriptionOfThread);
                    System.out.println("Dodano wątek!");
                } else {
                    numberOfThread = Integer.parseInt(inputChar);
                    this.forumController.getThread(numberOfThread);
                    continueView = this.threadView();

                }
            } catch (NumberFormatException e) {
                System.out.println("Wpisz odpowiedni znak!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nie ma takiego wątku!");
            }

        } while(continueView);

        return false;

    }

    public boolean threadView() {
        Scanner in = new Scanner(System.in);
        do {
            this.forumController.printThread();

            int numberOfAnswers = this.forumController.getNumberOfAnswers();
            System.out.println("Naciśnij A, aby dodać opowiedź!");
            if (this.forumController.isUserAdministrator()) {
                for (int i = 0; i < numberOfAnswers; i++) {
                    System.out.println("Naciśnij " + i + ", aby usunąć odpowiedź nr." + i);
                }
            }
            System.out.println("Naciśnij B, aby się cofnąć!");
            System.out.println("Naciśnij Q, aby wyjść!");


            String inputChar;
            int numberOfAnswer;
            String descriptionOfAnswer;

            try {

                inputChar = in.nextLine();
                if (inputChar.equals("Q") || inputChar.equals("q")) {
                    return false;
                } else if (inputChar.equals("B") || inputChar.equals("b")) {
                    return true;
                } else if (inputChar.equals("A") || inputChar.equals("a")) {
                    System.out.println("Wpisz odpowiedz!");
                    descriptionOfAnswer = in.nextLine();
                    this.forumController.addAnswer(descriptionOfAnswer);
                    System.out.println("Dodano odpowiedz!");
                } else if (this.forumController.isUserAdministrator()) {
                    numberOfAnswer = Integer.parseInt(inputChar);
                    this.forumController.deleteAnswer(numberOfAnswer);
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


    public boolean deleteThreadView() {
        Scanner in = new Scanner(System.in);
        do {
            int numberOfThreads = this.forumController.getNumberOfThreads();
            for (int i = 0; i < numberOfThreads; i++) {
                System.out.println("Naciśnij " + i  +", aby usunąć wątek nr." + i);
            }
            System.out.println("Naciśnij B, aby się cofnąć!");
            System.out.println("Naciśnij Q, aby wyjść!");

            String inputChar;
            int numberOfThread;

            try {

                inputChar = in.nextLine();
                if (inputChar.equals("Q") || inputChar.equals("q")) {
                    return false;
                } else if (inputChar.equals("B") || inputChar.equals("b")) {
                    return true;
                }  else {
                    numberOfThread = Integer.parseInt(inputChar);
                    this.forumController.deleteThread(numberOfThread);
                    System.out.println("Wątek usunięto!");
                    return true;

                }
            } catch (NumberFormatException e) {
                System.out.println("Wpisz odpowiedni znak!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nie ma takiej odpowiedzi!");
            }

        } while(true);
    }


}
