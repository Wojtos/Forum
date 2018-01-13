package view;

import controller.SecurityController;

import java.util.Scanner;

/**
 * Created by wojtek on 13.01.18.
 */
public class RegisterNewAdministrator {
    private SecurityController securityController;
    private Scanner in;

    public RegisterNewAdministrator(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public void registerNewAdministrator() {
        String nick;
        String password;
        System.out.println("Wpisz nick!");
        nick = in.nextLine();
        System.out.println("Wpisz hasło!");
        password = in.nextLine();
        if (this.securityController.registerAdministrator(nick, password)) {
            System.out.println("Zarejestrowano!");
        } else {
            System.out.println("Nick zajęty!");
        }
    }
}
