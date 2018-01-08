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
    SecurityController securityController;

    public Start(SecurityController securityController) {
        this.securityController = securityController;
    }

    public Boolean startView(){
        Scanner in = new Scanner(System.in);

        System.out.println("Witamy na Forum!");


        do {
            System.out.println("Naciśnij L, aby się zalogować!");
            System.out.println("Naciśnij R, aby się zarejestrować!");
            System.out.println("Naciśnij Q, aby się wyjść!");

            String inputChar;
            String nick;
            String password;

            try {

                inputChar = in.nextLine();
                if (inputChar.equals("L") || inputChar.equals("l")) {
                    System.out.println("Wpisz nick!");
                    nick = in.nextLine();
                    System.out.println("Wpisz hasło!");
                    password = in.nextLine();
                    this.securityController.logIn(nick, password);
                } else if (inputChar.equals("R") || inputChar.equals("r")) {
                    System.out.println("Wpisz nick!");
                    nick = in.nextLine();
                    System.out.println("Wpisz hasło!");
                    password = in.nextLine();
                    if (this.securityController.register(nick, password)) {
                        this.securityController.logIn(nick, password);
                    } else {
                        System.out.println("Nick zajęty!");
                    }
                } else if (inputChar.equals("Q") || inputChar.equals("q")) {
                    return false;
                } else {
                    System.out.println("Wpisz odpowiedni znak!");
                }
            } catch (BadLoginOrPasswordExcepetion e) {
                System.out.println(e.getMessage());
            }

        } while(!this.securityController.isLoggedIn());

        System.out.println("Zalogowano!");
        if (!this.securityController.isItAdministrator()){
            return true;
        } else {
            System.out.println("Jesteś administratorem!");
            boolean skip;
            do {
                System.out.println("Naciśnij R, aby zarejestrować nowego administratora!");
                System.out.println("Naciśnij L, aby przejść dalej!");
                System.out.println("Naciśnij Q, aby się wyjść!");


                String inputChar;
                String nick;
                String password;
                skip = false;




                    inputChar = in.nextLine();
                    if (inputChar.equals("L") || inputChar.equals("l")) {
                        skip = true;
                    } else if (inputChar.equals("R") || inputChar.equals("r")) {
                        System.out.println("Wpisz nick!");
                        nick = in.nextLine();
                        System.out.println("Wpisz hasło!");
                        password = in.nextLine();
                        if (this.securityController.registerAdministrator(nick, password)) {
                            System.out.println("Zarejestrowano!");
                        } else {
                            System.out.println("Nick zajęty!");
                        }
                    } else if (inputChar.equals("Q") || inputChar.equals("q")) {
                        return false;
                    } else {
                        System.out.println("Wpisz odpowiedni znak!");
                    }


            } while(!skip);

            return true;
        }
    }



}
