package view;

import controller.SecurityController;
import exception.BadLoginOrPasswordExcepetion;

import java.util.Scanner;

/**
 * Created by wojtek on 13.01.18.
 */
public class ChangeOtherUserPassword {
    private SecurityController securityController;
    private Scanner in;

    public ChangeOtherUserPassword(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public void changeOtherUserPassword() throws BadLoginOrPasswordExcepetion {
        String nick;
        String password;
        System.out.println("Wpisz nick użytkownika, któremu chesz zmienić hasło!");
        nick = in.nextLine();
        System.out.println("Wpisz nowe hasło!");
        password = in.nextLine();
        this.securityController.changeUserPassword(nick, password);
        System.out.println("Zmieniono!");
    }
}
