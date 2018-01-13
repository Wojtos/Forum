package view;

import controller.SecurityController;
import exception.BadLoginOrPasswordExcepetion;

import java.util.Scanner;

/**
 * Created by wojtek on 13.01.18.
 */
public class Logged {
    private SecurityController securityController;
    private Scanner in;

    public Logged(SecurityController securityController, Scanner in) {
        this.securityController = securityController;
        this.in = in;
    }

    public boolean logged() {
        System.out.println("Zalogowano!");
        if (this.securityController.getUser().isItAdministrator()) System.out.println("Jesteś administratorem!");
        boolean skip;
        do {
            if (this.securityController.getUser().isItAdministrator()) {
                System.out.println("Naciśnij R, aby zarejestrować nowego administratora!");
                System.out.println("Naciśnij Z, aby zmienić hasło innemu użytkowinikowi!");

            }
            System.out.println("Naciśnij C, aby zmienić hasło!");
            System.out.println("Naciśnij L, aby przejść dalej!");
            System.out.println("Naciśnij Q, aby się wyjść!");


            String inputChar;
            String nick;
            String password;
            String newPassword;
            String oldPassword;
            skip = false;



            try {
                inputChar = in.nextLine();
                if (inputChar.equals("L") || inputChar.equals("l")) {
                    skip = true;
                } else if (this.securityController.getUser().isItAdministrator() &&
                        (inputChar.equals("R") || inputChar.equals("r"))) {
                    RegisterNewAdministrator registerNewAdministrator = new RegisterNewAdministrator(securityController, in);
                    registerNewAdministrator.registerNewAdministrator();
                } else if (this.securityController.getUser().isItAdministrator() &&
                        (inputChar.equals("Z") || inputChar.equals("z"))) {
                    ChangeOtherUserPassword change = new ChangeOtherUserPassword(securityController, in);
                    change.changeOtherUserPassword();
                } else if (inputChar.equals("C") || inputChar.equals("c")) {
                    ChangeYourPassword changeY = new ChangeYourPassword(securityController, in);
                    changeY.changeYourPassword();
                } else if (inputChar.equals("Q") || inputChar.equals("q")) {
                    return false;
                } else {
                    System.out.println("Wpisz odpowiedni znak!");
                }
            } catch (BadLoginOrPasswordExcepetion e) {
                System.out.println(e.getMessage());
            }

        } while(!skip);

        return true;
    }
}
