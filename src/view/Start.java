package view;

import exception.BadLoginOrPasswordExcepetion;
import model.Administrator;
import model.Forum;
import model.User;

import controller.SecurityController;

import java.io.BufferedReader;
import java.io.IOException;

import static java.lang.System.*;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Created by wojtek on 06.01.18.
 */
public class Start {
    private SecurityController securityController;

    public Start(SecurityController securityController) {
        this.securityController = securityController;
    }

    public Boolean startView(){
        Scanner in = new Scanner(System.in);

        System.out.println("Witamy na Forum!");


        do {
            System.out.println("Naciśnij L, aby się zalogować!");
            System.out.println("Naciśnij R, aby się zarejestrować!");
            System.out.println("Naciśnij Q, aby wyjść!");

            String inputChar;;

            try {

                inputChar = in.nextLine();
                if (inputChar.equals("L") || inputChar.equals("l")) {
                    LogIn login = new LogIn(securityController, in);
                    login.login();
                } else if (inputChar.equals("R") || inputChar.equals("r")) {
                    Register register = new Register(securityController, in);
                    register.register();
                } else if (inputChar.equals("Q") || inputChar.equals("q")) {
                    return false;
                } else {
                    System.out.println("Wpisz odpowiedni znak!");
                }
            } catch (BadLoginOrPasswordExcepetion e) {
                System.out.println(e.getMessage());
            }

        } while(this.securityController.getUser() == null);

        Logged logged = new Logged(securityController, in);
        return logged.logged();
        }




}
