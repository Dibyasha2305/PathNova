package modules;

public class SkillAnalyzer {
    public static String analyze(String goal, String skills) {
        String result = "\n--- Skill Analysis ---\n";
        skills = skills.toLowerCase();
        if (goal.equalsIgnoreCase("software engineer")) {
            if (!skills.contains("dsa")) {
                result += "- Learn Data Structures & Algorithms\n";
            }
            if (!skills.contains("java")) {
                result += "- Improve Java skills\n";
            }
            if (!skills.contains("database")) {
                result += "- Learn Databases (SQL)\n";
            }
            if (!skills.contains("projects")) {
                result += "- Build more real-world projects\n";
            }
        }
        result += "Keep improving!!";
        return result;
    }
}