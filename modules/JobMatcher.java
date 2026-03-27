package modules;

public class JobMatcher {

    public static String match(String resume, String jobDesc) {

        resume = resume.toLowerCase();
        jobDesc = jobDesc.toLowerCase();
        String result = "\n-------- Job Match Analysis -------\n";

        String[] skills = {"java", "python", "sql", "dsa", "api", "database", "spring"};
        int[] weights = {3, 3, 2, 3, 2, 2, 2};

        int totalWeight = 0;
        int matchedWeight = 0;

        String missing = "\nMissing Skills:\n";

        int programming = 0;
        int core = 0;
        int backend = 0;

        int progTotal = 0;
        int coreTotal = 0;
        int backendTotal = 0;

        for (int i = 0; i < skills.length; i++) {

            String skill = skills[i];
            int weight = weights[i];

            if (jobDesc.contains(skill)) {

                totalWeight += weight;

                if (skill.equals("java") || skill.equals("python")) {
                    progTotal += weight;
                }
                if (skill.equals("dsa")) {
                    coreTotal += weight;
                }
                if (skill.equals("api") || skill.equals("database") || skill.equals("spring")) {
                    backendTotal += weight;
                }
                if (resume.contains(skill)) {
                    matchedWeight += weight;

                    if (skill.equals("java") || skill.equals("python")) {
                        programming += weight;
                    }
                    if (skill.equals("dsa")) {
                        core += weight;
                    }
                    if (skill.equals("api") || skill.equals("database") || skill.equals("spring")) {
                        backend += weight;
                    }
                } else {
                    missing += "- " + skill + "\n";
                }
            }
        }

        int matchPercent = 0;
        if (totalWeight > 0) {
            matchPercent = (matchedWeight * 100) / totalWeight;
        }
        result += "Match Percentage: " + matchPercent + "%\n";

        if (matchPercent >= 80) {
            result += "Strong match! You are job-ready \n";
        } else if (matchPercent >= 50) {
            result += "Moderate match. Improve missing areas.\n";
        } else {
            result += "Low match. Significant skill improvement needed.\n";
        }
        result += "\n------ Skill Category Analysis -------\n";

        if (progTotal > 0) {
            if (programming < progTotal / 2) {
                result += "- Weak in Programming (Java/Python)\n";
            } else {
                result += "- Strong in Programming\n";
            }
        }

        if (coreTotal > 0) {
            if (core < coreTotal / 2) {
                result += "- Weak in Core Concepts (DSA)\n";
            } else {
                result += "- Strong in Core Concepts\n";
            }
        }
        if (backendTotal > 0) {
            if (backend < backendTotal / 2) {
                result += "- Weak in Backend Development\n";
            } else {
                result += "- Strong in Backend Development\n";
            }
        }
        result += missing;

        result += "\n--- Suggestions ---\n";
        if (!resume.contains("dsa")) {
            result += "- Practice DSA (Arrays → Trees → Graphs)\n";
        }
        if (!resume.contains("api")) {
            result += "- Learn REST APIs\n";
        }
        if (!resume.contains("database")) {
            result += "- Learn SQL & Database Design\n";
        }
        result += "- Build 2–3 real-world projects\n";
        result += "\n----------------------------------------------\n";
        return result;
    }
}