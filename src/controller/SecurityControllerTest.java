package controller;

import exception.BadLoginOrPasswordExcepetion;
import model.Administrator;
import model.Forum;
import model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by wojtek on 06.01.18.
 */
class SecurityControllerTest {

    @BeforeAll
    static void initAll() {

    }

    @Test
    void logAdmin(){
        SecurityController sc = new SecurityController(new Forum());
        User user;
        try {
            assertNotNull(user = sc.logIn("admin","admin"));
            assertTrue(user.isItAdministrator());
        } catch (BadLoginOrPasswordExcepetion e) {
            e.printStackTrace();
        }
    }

    @Test
    void addAndLogUser(){
        SecurityController sc = new SecurityController(new Forum());
        sc.register("a","b");
        User user;
        try {
            assertNotNull(user = sc.logIn("a","b"));
            assertFalse(user.isItAdministrator());

        } catch (BadLoginOrPasswordExcepetion e) {
            e.printStackTrace();
        }
    }

    @Test
    void logUser(){
        SecurityController sc = new SecurityController(new Forum());
        sc.register("a","b");
        User user1;
        User user2;
        User user3;
        try {
            assertNotNull(user1 = sc.logIn("admin","admin"));
            assertTrue(user1.getNick().equals("admin"));
            assertNotNull(user2 = sc.logIn("a","b"));
            assertTrue(user2.getNick().equals("a"));
            assertThrows(BadLoginOrPasswordExcepetion.class, (Executable) (user3 = sc.logIn("a","bledne")));
        } catch (BadLoginOrPasswordExcepetion e) {
            e.printStackTrace();
        }
    }
}