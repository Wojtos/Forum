package view;

import controller.SecurityController;
import exception.BadLoginOrPasswordExcepetion;

import java.util.Scanner;

/**
 * Created by wojtek on 13.01.18.
 */
public class Register {
    private SecurityController securityController;
    private Scanner in;

    public Register(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public void register() throws BadLoginOrPasswordExcepetion {
        String nick;
        String password;
        System.out.println("Wpisz nick!");
        nick = in.nextLine();
        System.out.println("Wpisz hasło!");
        password = in.nextLine();
        if (this.securityController.register(nick, password)) {
            this.securityController.logIn(nick, password);
        } else {
            System.out.println("Nick zajęty!");
        }
    }
}
