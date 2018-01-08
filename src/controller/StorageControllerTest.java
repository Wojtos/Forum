package controller;

import exception.BadLoginOrPasswordExcepetion;
import model.Forum;
import model.Thread;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by wojtek on 08.01.18.
 */
class StorageControllerTest {
    private static Forum forum;
    @BeforeEach
    void initBeforeEach() {
        forum = new Forum();
        SecurityController securityController = new SecurityController(forum);
        securityController.register("Leo","Messi");

        ForumController forumController = new ForumController(forum, securityController.getUser());
        forumController.addThread("Złota Płka 2017", "To jest dramat!");
        forumController.getThread(0);
        forumController.addAnswer("Nie jest");
        forumController.addAnswer("Jest");
        forumController.deleteAnswer(0);
        forumController.addThread("Złota Płka 2018", "Będzie moja!");
        forumController.getThread(1);
        forumController.addAnswer("Zobaczycie!");
        forumController.addAnswer("I sie zdziwicie!");
    }

    @Test
    void saveAndLoadForum() {
        assertTrue(StorageController.saveForum(forum));
        Forum loadedForum = StorageController.loadForum();
        assertNotNull(loadedForum);
        assertTrue(forum.getThreads().size() == loadedForum.getThreads().size());
        assertEquals(forum.getThread(0).getName(),
                loadedForum.getThread(0).getName());
        assertEquals(forum.getThread(0).getUser().getNick(),
                loadedForum.getThread(0).getUser().getNick());
        assertEquals(forum.getThread(0).getAnswers().size(),
                loadedForum.getThread(0).getAnswers().size());
        assertEquals(forum.getThread(0).getAnswers().getFirst().getAnswer(),
                loadedForum.getThread(0).getAnswers().getFirst().getAnswer());
        assertEquals(forum.getThread(0).getAnswers().getFirst().getUser().getNick(),
                loadedForum.getThread(0).getAnswers().getFirst().getUser().getNick());
        assertEquals(forum.getThread(1).getName(),
                loadedForum.getThread(1).getName());
        assertEquals(forum.getThread(1).getUser().getNick(),
                loadedForum.getThread(1).getUser().getNick());
        assertEquals(forum.getThread(1).getAnswers().size(),
                loadedForum.getThread(1).getAnswers().size());
        assertEquals(forum.getThread(1).getAnswers().getFirst().getAnswer(),
                loadedForum.getThread(1).getAnswers().getFirst().getAnswer());
        assertEquals(forum.getThread(1).getAnswers().getLast().getAnswer(),
                loadedForum.getThread(1).getAnswers().getLast().getAnswer());
        assertEquals(forum.getThread(1).getAnswers().getLast().getUser().getNick(),
                loadedForum.getThread(1).getAnswers().getLast().getUser().getNick());


    }


}