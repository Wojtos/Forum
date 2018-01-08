package controller;

import exception.BadLoginOrPasswordExcepetion;
import model.Administrator;
import model.Forum;
import model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        try {
            assertTrue(sc.logIn("admin","admin"));
            assertTrue(sc.isLoggedIn());
            assertTrue(sc.getUser() instanceof Administrator);
        } catch (BadLoginOrPasswordExcepetion e) {
            e.printStackTrace();
        }
    }

    @Test
    void addAndLogUser(){
        SecurityController sc = new SecurityController(new Forum());
        sc.register("a","b");
        try {
            assertTrue(sc.logIn("a","b"));
            assertTrue(sc.isLoggedIn());
            assertFalse(sc.getUser() instanceof Administrator);

        } catch (BadLoginOrPasswordExcepetion e) {
            e.printStackTrace();
        }
    }

    @Test
    void logUser(){
        SecurityController sc = new SecurityController(new Forum());
        sc.register("a","b");
        try {
            assertTrue(sc.logIn("admin","admin"));
            assertTrue(sc.getUser().getNick().equals("admin"));
            assertTrue(sc.logIn("a","b"));
            assertTrue(sc.getUser().getNick().equals("a"));
            assertFalse(sc.logIn("a","bledne"));
        } catch (BadLoginOrPasswordExcepetion e) {
            e.printStackTrace();
        }
    }
}