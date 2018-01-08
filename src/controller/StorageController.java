package controller;

import model.Forum;
import java.io.*;


/**
 * Created by wojtek on 06.01.18.
 */
public class StorageController {
    protected final static String fileName = "src/model/save.ser";

    public static Forum loadForum() {
        try (FileInputStream istream = new FileInputStream(fileName)) {
            ObjectInputStream q = new ObjectInputStream(istream);
            Forum forum = (Forum)q.readObject();

            return forum;

        } catch (Exception e) {
            return null;
        }
    }


    public static boolean saveForum(Forum forum) {
        try (FileOutputStream ostream = new FileOutputStream(fileName)) {
            ObjectOutputStream p = new ObjectOutputStream(ostream);
            p.writeObject(forum);
            p.flush();
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
