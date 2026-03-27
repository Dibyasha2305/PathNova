package modules;
public class DMGenerator {
    public static String generate(String name, String field) {
        String message = "Hi " + name +
                ", I came across your profile and really admire your work in " +
                field +
                ". I am currently a student exploring this field and would love to connect and learn from you.";
        return message;
    }
}