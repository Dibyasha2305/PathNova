package modules;

public class ResumeScorer {

    public static String score(String input) {

        int score = 0;
        input = input.toLowerCase();

        String feedback = "\n--- Resume Score ---\n";

        if (input.contains("developed") || input.contains("designed") || input.contains("implemented")) {
            score += 3;
        } else {
            feedback += "- Use strong action words (developed, designed, implemented)\n";
        }
        if (input.contains("java") || input.contains("python") || input.contains("sql")) {
            score += 3;
        } else {
            feedback += "- Add technical skills (Java, Python, SQL)\n";
        }
        if (input.length() > 20) {
            score += 2;
        } else {
            feedback += "- Make the sentence more descriptive\n";
        }
        if (input.contains("project") || input.contains("application")) {
            score += 2;
        }
        feedback += "Score: " + score + "/10\n";
        return feedback;
    }
}