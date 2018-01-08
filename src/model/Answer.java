package model;

import java.io.Serializable;

/**
 * Created by wojtek on 07.01.18.
 */
public class Answer implements Serializable {
    private User user;
    private String answer;

    public Answer(User user, String answer) {
        this.user = user;
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public String getAnswer() {
        return answer;
    }

    public void printAnswer() {
        System.out.println("Odpowiedź użytkownika: " + this.user.getNick());
        System.out.println(this.answer);
        System.out.println("");
    }
}
