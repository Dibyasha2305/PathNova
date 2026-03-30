package modules;
public class JobMatcher {
    public static String match(String resume, String jobDesc) {
        resume = normalize(resume);
        jobDesc = normalize(jobDesc);

        String result = "\n============ JOB MATCH ANALYSIS =============\n";

        String[] skills = {"java", "python", "sql", "dsa", "api", "database", "spring"};
        int[] weights = {3, 3, 2, 3, 2, 2, 2};
        int totalWeight = 0;
        int matchedWeight = 0;

        StringBuilder missing = new StringBuilder();
        int programming = 0, core = 0, backend = 0;
        int progTotal = 0, coreTotal = 0, backendTotal = 0;

        for (int i = 0; i < skills.length; i++) {

            String skill = skills[i];
            int weight = weights[i];

            if (jobDesc.contains(skill)) {

                totalWeight += weight;

                // Categorywise grouping
                if (skill.equals("java") || skill.equals("python")) progTotal += weight;
                if (skill.equals("dsa")) coreTotal += weight;
                if (skill.equals("api") || skill.equals("database") || skill.equals("spring")) backendTotal += weight;

                if (resume.contains(skill)) {
                    matchedWeight += weight;

                    if (skill.equals("java") || skill.equals("python")) programming += weight;
                    if (skill.equals("dsa")) core += weight;
                    if (skill.equals("api") || skill.equals("database") || skill.equals("spring")) backend += weight;

                } else {
                    missing.append("- ").append(skill).append("\n");
                }
            }
        }
        int matchPercent = (totalWeight > 0) ? (matchedWeight * 100) / totalWeight : 0;
        result += "Match Score: " + matchPercent + "%\n";
        if (matchPercent >= 80) {
            result += "Excellent match! You're job-ready \n";
        } else if (matchPercent >= 50) {
            result += "Good match. Just a few improvements needed.\n";
        } else {
            result += "Low match. Focus on building core skills.\n";
        }
//analysis
        result += "\n------ Skill Category Analysis ------\n";

        if (progTotal > 0) {
            result += (programming >= progTotal / 2)
                    ? "- Strong in Programming\n"
                    : "- Improve Programming (Java/Python)\n";
        }

        if (coreTotal > 0) {
            result += (core >= coreTotal / 2)
                    ? "- Strong in Core Concepts (DSA)\n"
                    : "- Weak in Core Concepts (DSA)\n";
        }

        if (backendTotal > 0) {
            result += (backend >= backendTotal / 2)
                    ? "- Strong in Backend Development\n"
                    : "- Improve Backend Skills\n";
        }

        if (missing.length() > 0) {
            result += "\nMissing Skills:\n" + missing;
        } else {
            result += "\nNo major skill gaps detected \n";
        }

        result += "\n------ Suggestions ------\n";

        if (!resume.contains("dsa")) {
            result += "- Practice DSA (Arrays -> Trees -> Graphs)\n";
        }
        if (!resume.contains("api")) {
            result += "- Learn REST API development\n";
        }
        if (!resume.contains("database")) {
            result += "- Strengthen SQL & database design\n";
        }
        result += "- Build 2-3 strong real-world projects\n";
        result += "\n====================================\n";

        return result;
    }
    private static String normalize(String text) {
        text = text.toLowerCase();
        text = text.replace("rest api", "api");
        text = text.replace("apis", "api");
        text = text.replace("structured query language", "sql");
        return text;
    }
}