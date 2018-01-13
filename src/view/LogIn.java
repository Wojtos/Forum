package view;

import controller.SecurityController;
import exception.BadLoginOrPasswordExcepetion;
import model.User;

import java.util.Scanner;

/**
 * Created by wojtek on 13.01.18.
 */
public class LogIn {
    private SecurityController securityController;
    private Scanner in;

    public LogIn(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public void login() throws BadLoginOrPasswordExcepetion {
        String nick;
        String password;
        System.out.println("Wpisz nick!");
        nick = in.nextLine();
        System.out.println("Wpisz hasło!");
        password = in.nextLine();
        this.securityController.logIn(nick, password);
    }
}
