package modules;

public class ResumeEnhancer {
    public static String improve(String input) {

        String improved = input.replace("made", "developed ")
                               .replace("created", "designed ");
        improved = "I " + improved + " using efficient coding practices.";
        return improved;
    }
}