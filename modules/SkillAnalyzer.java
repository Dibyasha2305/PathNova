package modules;
public class SkillAnalyzer {
    public static String analyze(String goal, String skills) {
        goal = goal.toLowerCase();
        skills = skills.toLowerCase();
        StringBuilder result = new StringBuilder("\n========== SKILL ANALYSIS ==========\n");

        String[] requiredSkills;
        if (goal.contains("software")) {
            requiredSkills = new String[]{"java", "dsa", "database", "api", "projects"};
        }
        else if (goal.contains("ai") || goal.contains("data")) {
            requiredSkills = new String[]{"python", "machine learning", "statistics", "numpy", "pandas", "projects"};
        }
        else if (goal.contains("web")) {
            requiredSkills = new String[]{"html", "css", "javascript", "react", "api", "projects"};
        }
        else {
            requiredSkills = new String[]{"problem solving", "communication", "projects"};
        }
        int match = 0;
        StringBuilder missing = new StringBuilder();
        for (String skill : requiredSkills) {
            if (skills.contains(skill)) {
                match++;
            } else {
                missing.append("- ").append(skill).append("\n");
            }
        }
        int percent = (match * 100) / requiredSkills.length;

        result.append("Match Level: ").append(percent).append("%\n\n");

        if (percent >= 75) {
            result.append("Strong profile for this role \n");
        } else if (percent >= 40) {
            result.append("Moderate profile. Needs improvement.\n");
        } else {
            result.append("Low readiness. Focus on fundamentals.\n");
        }

        if (missing.length() > 0) {
            result.append("\nMissing Skills:\n").append(missing);
        } else {
            result.append("\nNo major skill gaps detected \n");
        }

        result.append("\n------ Suggestions ------\n");

        if (!skills.contains("projects")) {
            result.append("- Build real-world projects\n");
        }

        if (goal.contains("software") && !skills.contains("dsa")) {
            result.append("- Practice Data Structures & Algorithms\n");
        }

        if ((goal.contains("ai") || goal.contains("data")) && !skills.contains("machine learning")) {
            result.append("- Learn Machine Learning basics\n");
        }

        if (goal.contains("web") && !skills.contains("javascript")) {
            result.append("- Strengthen JavaScript fundamentals\n");
        }
        result.append("- Stay consistent and keep improving \n");
        result.append("\n========================================\n");
        return result.toString();
    }
}