package controller;

import exception.BadLoginOrPasswordExcepetion;
import model.Forum;
import model.Thread;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by wojtek on 07.01.18.
 */
class ForumControllerTest {
    private static ForumController forumController;
    @BeforeEach
    void initBeforeEach() {
        Forum forum = new Forum();
        SecurityController securityController = new SecurityController(forum);
        try {
            securityController.logIn("admin","admin");
        } catch (BadLoginOrPasswordExcepetion badLoginOrPasswordExcepetion) {
            badLoginOrPasswordExcepetion.printStackTrace();
        }
        forumController = new ForumController(forum, securityController.getUser());
    }

    @Test
    void addAndGetThread() {
        assertTrue(forumController.addThread("nowy","kolor"));
        assertNotNull(forumController.getThread(0));
        assertTrue(forumController.currentThread.getDescription().equals("kolor"));
        assertTrue(forumController.currentThread.getName().equals("nowy"));
        assertTrue(forumController.currentThread.getUser().getNick().equals("admin"));
    }


    @Test
    void addAnswer() {
        assertTrue(forumController.addThread("nowy","kolor"));
        assertTrue(forumController.addThread("dajemy","tu"));
        assertNotNull(forumController.getThread(1));
        assertTrue(forumController.addAnswer("cos tam"));
        assertTrue(forumController.currentThread.getAnswers().getFirst().getAnswer().equals("cos tam"));

    }

    @Test()
    void deleteThread() {
        assertTrue(forumController.addThread("nowy","kolor"));
        assertNotNull(forumController.getThread(0));
        assertTrue(forumController.deleteThread(0));
        try {
            assertNull(forumController.getThread(0));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAllThreads() {
        assertTrue(forumController.addThread("nowy","kolor"));
        assertTrue(forumController.addThread("dajemy","tu"));
        assertTrue(forumController.getNumberOfThreads() == 2);
        assertNotNull(forumController.getThread(1));
        assertTrue(forumController.currentThread.getName().equals("dajemy"));

    }

    @Test
    void deleteAnswer() {
        assertTrue(forumController.addThread("nowy","kolor"));
        assertNotNull(forumController.getThread(0));
        assertTrue(forumController.addAnswer("cos tam"));
        assertTrue(forumController.addAnswer("jeszcze tylko ze 2 zmiany klubu jak Zlatan"));
        assertTrue(forumController.deleteAnswer(0));
        assertTrue(forumController.currentThread.getAnswers().getFirst().getAnswer()
                .equals("jeszcze tylko ze 2 zmiany klubu jak Zlatan"));
        assertTrue(forumController.currentThread.getAnswers().size() == 1);


    }


}