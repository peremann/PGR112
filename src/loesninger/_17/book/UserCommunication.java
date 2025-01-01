package loesninger._17.book;

import java.util.Arrays;

public class UserCommunication {
    public static final String WELCOME = "Welcome to the book register. Here are your options:";
    public static final String USER_CHOICE_PROMPT = "What do you choose?";
    public static final String ENTER_GENRE;
    public static final String ENTER_AUTHOR;

    static {
        ENTER_AUTHOR = "Enter author:";
    }

    static {
        ENTER_GENRE = String.format("Enter genre %s", Arrays.toString(Genre.values()));
    }
}
