package view;

import controller.ForumController;
import model.Thread;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by wojtek on 13.01.18.
 */
public class DeleteThreadView {
    private ForumController forumController;
    private Scanner in;

    public DeleteThreadView(ForumController forumController, Scanner in) {
        this.forumController = forumController;
        this.in = in;
    }

    public boolean deleteThreadView() {
        do {
            LinkedList<Thread> threads = this.forumController.getForum().getThreads();
            int i = 0;
            for (Thread thread : threads) {
                System.out.println("Naciśnij " + i  +", aby usunąć wątek nr." + i + " o nazwie: " + thread.getName());
                i++;
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
                    this.forumController.getForum().deleteThread(numberOfThread);
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
