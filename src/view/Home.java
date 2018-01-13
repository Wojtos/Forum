package view;

import controller.ForumController;
import exception.BadLoginOrPasswordExcepetion;
import model.Answer;
import model.Forum;
import model.Thread;
import model.User;

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
            this.forumController.getForum().printForum();
            LinkedList<Thread> threads = this.forumController.getForum().getThreads();
            int i = 0;
            for (Thread thread : threads) {
                System.out.println("Naciśnij " + i  +", aby wejść do wątku nr." + i + " o nazwie: " + thread.getName());
                i++;
            }
            System.out.println("Naciśnij D, aby dodać wątek!");
            if (this.forumController.getLoggedUser().isItAdministrator())
                System.out.println("Naciśnij U, aby przejść do usuwania wątków!");
            System.out.println("Naciśnij Q, aby wyjść!");

            String inputChar;
            int numberOfThread;


            continueView = true;

            try {

                inputChar = in.nextLine();
                if (inputChar.equals("Q") || inputChar.equals("q")) {
                    return false;
                } else if (this.forumController.getLoggedUser().isItAdministrator() &&
                        (inputChar.equals("U") || inputChar.equals("u"))) {
                    DeleteThreadView deleteThreadView = new DeleteThreadView(forumController, in);
                    if (!deleteThreadView.deleteThreadView()) return false;
                } else if (inputChar.equals("D") || inputChar.equals("d")) {
                    AddThreadView addThreadView = new AddThreadView(forumController, in);
                    addThreadView.addThreadView();
                } else {
                    numberOfThread = Integer.parseInt(inputChar);
                    this.forumController.goToThread(numberOfThread);
                    ThreadView threadView = new ThreadView(this.forumController, in);
                    if (!threadView.threadView()) return false;

                }
            } catch (NumberFormatException e) {
                System.out.println("Wpisz odpowiedni znak!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nie ma takiego wątku!");
            }

        } while(continueView);

        return false;

    }

}
