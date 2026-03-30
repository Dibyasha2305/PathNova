package modules;
import java.util.Random;
public class DMGenerator {

    public static String generate(String name, String field) {
        field = field.toLowerCase();

        String intro = "";
        String compliment = "";
        String closing = "";

        // Multiple tone options
        String[] intros = {
            "Hi " + name + ",",
            "Hello " + name + ",",
            "Hey " + name + ","
        };

        String[] closings = {
            "Would love to connect and learn from you!",
            "I'd really appreciate any guidance you can share.",
            "Looking forward to connecting with you!"
        };

        Random rand = new Random();

        intro = intros[rand.nextInt(intros.length)];
        closing = closings[rand.nextInt(closings.length)];

        //Field-based personalization
        if (field.contains("ai") || field.contains("machine learning")) {
            compliment = "I've been exploring AI and your work really stood out to me.";
        }
        else if (field.contains("software") || field.contains("developer")) {
            compliment = "I really admire your experience in software development.";
        }
        else if (field.contains("data")) {
            compliment = "Your work in data science is really inspiring.";
        }
        else {
            compliment = "I came across your profile and found your work very inspiring.";
        }

        String message = intro + " " + compliment +
                " I am currently a student exploring " + field +
                " and trying to grow in this domain. " + closing;
        return message;
    }
}