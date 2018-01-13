package model;

import java.util.LinkedList;
import java.io.Serializable;
import exception.BadLoginOrPasswordExcepetion;

/**
 * Created by wojtek on 06.01.18.
 */
public class Forum implements Serializable {

    private LinkedList<User> users;
    private LinkedList<Thread> threads;


    public Forum() {
        users = new LinkedList<>();
        threads = new LinkedList<>();
        Administrator admin = new Administrator("admin","admin");
        this.addUser(admin);

    }

    public Boolean isthisNickFree(String nick) {
        for (User user: users) {
            if (user.getNick().equals(nick)) return false;
        }
        return true;

    }

    public User getUserByNick(String nick) throws BadLoginOrPasswordExcepetion{
        for (User user: users) {
            if (user.getNick().equals(nick)) return user;
        }
        throw new BadLoginOrPasswordExcepetion();
    }

    public Boolean addUser(User newUser) {
         return this.users.add(newUser);
    }

    public Boolean addThread(Thread thread) {
        return this.threads.add(thread);
    }

    public Thread getThread(int number) throws IndexOutOfBoundsException{
        return this.threads.get(number);
    }

    public Boolean deleteThread(int number) throws IndexOutOfBoundsException{
        this.threads.remove(number);
        return true;
    }

    public LinkedList<Thread> getThreads() {
        return this.threads;
    }

    public void printForum() {
        System.out.println("Oto zawartość forum!");
        int counter = 0;
        for (Thread thread : threads) {
            System.out.println("Wątek nr." + counter );
            System.out.println("Wątek o nazwie: " + thread.getName() + ", stworzony przez: " +
            thread.getUser().getNick());
            counter++;
        }
        System.out.println("");
    }
}
