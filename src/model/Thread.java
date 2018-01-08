package model;

import java.util.LinkedList;

/**
 * Created by wojtek on 07.01.18.
 */
public class Thread {
    private User user;
    private String name;
    private String description;
    private LinkedList<Answer> answers;

    public Thread(User user, String name, String description) {
        this.user = user;
        this.name = name;
        this.description = description;
        this.answers = new LinkedList<>();
    }


    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean addAnswer(Answer answer) {
        answers.add(answer);
        return true;
    }

    public LinkedList<Answer> getAnswers() {
        return answers;
    }

    public Boolean deleteAnswer(int number) throws IndexOutOfBoundsException{
        this.answers.remove(number);
        return true;
    }

    public void printThread() {
        System.out.println("Wątek o nazwie: " + this.name + ", stworzony przez: " + this.user.getNick());
        System.out.println("Opis:" + this.description);
        int counter = 0;
        for (Answer answer : answers) {
            System.out.println("Odpowiedź nr." + counter );
            answer.printAnswer();
            counter++;
        }
        System.out.println("");
    }




}
