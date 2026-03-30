package modules;
import java.util.Random;
public class ResumeEnhancer {
    public static String improve(String input) {

        input = input.toLowerCase().trim();
        if (input.contains("made") || input.contains("created") || input.contains("built")) {
            input = input.replace("made", "developed")
                         .replace("created", "designed")
                         .replace("built", "implemented");
        }
        String tech = "";
        if (input.contains("java")) tech = "Java";
        else if (input.contains("python")) tech = "Python";
        else if (input.contains("sql")) tech = "SQL";
        else if (input.contains("react")) tech = "React";
        else if (input.contains("api")) tech = "REST APIs";
        String[] templates = {
            "I %s using %s, focusing on efficiency and clean code.",
            "Developed %s leveraging %s with optimized performance.",
            "Designed %s utilizing %s and best coding practices.",
            "Implemented %s using %s to deliver reliable solutions."
        };

        Random rand = new Random();
        String template = templates[rand.nextInt(templates.length)];
        String result;
        if (!tech.equals("")) {
            result = String.format(template, input, tech);
        } else {
            result = "I " + input + " with a focus on efficient and clean coding practices.";
        }

        result = result.substring(0, 1).toUpperCase() + result.substring(1);

        return result;
    }
}