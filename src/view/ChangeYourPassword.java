package view;

import controller.SecurityController;
import exception.BadLoginOrPasswordExcepetion;

import java.util.Scanner;

/**
 * Created by wojtek on 13.01.18.
 */
public class ChangeYourPassword {
    private SecurityController securityController;
    private Scanner in;

    public ChangeYourPassword(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public void changeYourPassword() {
        String oldPassword;
        String newPassword;
        System.out.println("Wpisz stare hasło!");
        oldPassword = in.nextLine();
        System.out.println("Wpisz nowe hasło!");
        newPassword = in.nextLine();
        if (this.securityController.getUser().changePassword(oldPassword, newPassword)) {
            System.out.println("Hasło zmienione!");
        } else {
            System.out.println("Złe stare hasło!");
        }
    }
}
