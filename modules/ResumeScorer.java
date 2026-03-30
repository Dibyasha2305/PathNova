package modules;
public class ResumeScorer {
    public static String score(String input) {
        input = input.toLowerCase().trim();
        int score = 0;
        StringBuilder feedback = new StringBuilder("\n--- Resume Score Analysis ---\n");

        if (input.contains("developed") || input.contains("designed") || input.contains("implemented")) {
            score += 3;
            feedback.append(" Strong action verb used\n");
        } else if (input.contains("created") || input.contains("built") || input.contains("made")) {
            score += 2;
            feedback.append(" Good, but use stronger verbs like 'developed' or 'implemented'\n");
        } else {
            feedback.append(" Add strong action words\n");
        }

        if (input.contains("java") || input.contains("python") || input.contains("sql") || input.contains("react")) {
            score += 3;
            feedback.append("Technical skills mentioned\n");
        } else {
            feedback.append(" Add technologies (Java, Python, SQL, etc.)\n");
        }

        if (input.length() > 30) {
            score += 2;
            feedback.append(" Good description length\n");
        } else if (input.length() > 15) {
            score += 1;
            feedback.append(" Can be more descriptive\n");
        } else {
            feedback.append(" Too short, add more details\n");
        }

        if (input.contains("improved") || input.contains("optimized") || input.contains("increased")) {
            score += 1;
            feedback.append(" Shows impact/results\n");
        }

        if (input.matches(".*\\d+.*")) {
            score += 1;
            feedback.append(" Includes measurable results\n");
        }

        if (score > 10) score = 10;

        feedback.append("\nFinal Score: ").append(score).append("/10\n");

        if (score >= 8) {
            feedback.append("Excellent resume line!!! \n");
        } else if (score >= 5) {
            feedback.append("Good, but can be improved.\n");
        } else {
            feedback.append("Needs significant improvement.\n");
        }

        return feedback.toString();
    }
}