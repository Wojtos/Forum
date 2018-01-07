package exception;

/**
 * Created by wojtek on 06.01.18.
 */
public class BadLoginOrPasswordExcepetion extends Exception{
    public String getMessage() {
        return "Zle hasło lub nazwa użtkownika!";
    }
}
