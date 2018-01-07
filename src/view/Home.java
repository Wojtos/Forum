package view;

import exception.BadLoginOrPasswordExcepetion;
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
public class Home {
    User user;

    public void startView(Forum forum){
        SecurityController securityController = new SecurityController(forum);
        this.user = null;

        Scanner in = new Scanner(System.in);

        System.out.println("Witamy na Forum!");


        do {
            System.out.println("Naciśnij L, aby się zalogować!");
            System.out.println("Naciśnij R, aby się zarejestrować!");


            try {
                String inputChar;
                String nick;
                String password;

                inputChar = in.nextLine();
                System.out.println(inputChar);
                if (inputChar.equals("L") || inputChar.equals("L")) {
                    System.out.println("Wpisz nick!");
                    nick = in.nextLine();
                    System.out.println(nick);
                    System.out.println("Wpisz hasło!");
                    password = in.nextLine();
                    System.out.println(password);
                    user = securityController.logIn(nick, password);
                } else if (inputChar.equals("R") || inputChar.equals("r")) {
                    System.out.println("Wpisz nick!");
                    nick = in.nextLine();
                    System.out.println(nick);
                    System.out.println("Wpisz hasło!");
                    password = in.nextLine();
                    System.out.println(password);
                    if (securityController.register(nick, password)) {
                        user = securityController.logIn(nick, password);
                    }
                } else {
                    System.out.println("Wpisz odpowiedni znak!");
                }
            } catch (BadLoginOrPasswordExcepetion e) {
                System.out.println(e.getMessage());
            }

        } while(this.user == null);
    }

    public static void main(String[] args) {
        Home home = new Home();
        home.startView(new Forum());
    }
}
