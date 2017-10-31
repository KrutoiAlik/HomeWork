import java.util.*;

public class ResourceBundleTask {

    static ResourceBundle questions;
    static ResourceBundle answers;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.print("Locales: en/ru ");

        Locale locale = new Locale(console.nextLine());
        questions = ResourceBundle.getBundle("Questions", locale);

        System.out.println(ResourceBundle.getBundle("Choice", locale).getObject("choice") + "\r\n");
        new ResourceBundleTask().viewAllQuestions();

        answers = ResourceBundle.getBundle("Answers", locale);
        System.out.println(answers.getObject(console.nextLine()));
    }

    void viewAllQuestions() {
        Enumeration e = questions.getKeys();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            System.out.println(key + ". " + questions.getObject(key));
        }
    }

}
