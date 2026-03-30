package modules;
public class RoadmapGenerator {
    public static String generate(String goal) {
        goal = goal.toLowerCase();

        StringBuilder roadmap = new StringBuilder("\n========== CAREER ROADMAP ==========\n");
        if (goal.contains("software")) {
            roadmap.append("\n Beginner Level:\n");
            roadmap.append("- Learn Programming Basics (Java / Python)\n");
            roadmap.append("- Understand OOP Concepts\n");

            roadmap.append("\n Intermediate Level:\n");
            roadmap.append("- Master Data Structures & Algorithms\n");
            roadmap.append("- Learn Databases (SQL)\n");
            roadmap.append("- Understand Backend (APIs, Spring)\n");

            roadmap.append("\n Advanced Level:\n");
            roadmap.append("- Build 3-4 Real-world Projects\n");
            roadmap.append("- Practice System Design Basics\n");
            roadmap.append("- Prepare for Technical Interviews\n");

            roadmap.append("\n Final Step:\n");
            roadmap.append("- Apply for Internships / Jobs\n");
        }

        else if (goal.contains("data") || goal.contains("ai")) {

            roadmap.append("\n Beginner Level:\n");
            roadmap.append("- Learn Python & Libraries (NumPy, Pandas)\n");
            roadmap.append("- Understand Basic Statistics\n");

            roadmap.append("\n Intermediate Level:\n");
            roadmap.append("- Learn Machine Learning Algorithms\n");
            roadmap.append("- Work on Data Cleaning & EDA\n");

            roadmap.append("\n Advanced Level:\n");
            roadmap.append("- Build ML Projects (Prediction, Classification)\n");
            roadmap.append("- Learn Deep Learning Basics\n");

            roadmap.append("\n Final Step:\n");
            roadmap.append("- Build Portfolio & Apply for Roles\n");
        }
        else if (goal.contains("web")) {

            roadmap.append("\n Beginner Level:\n");
            roadmap.append("- Learn HTML, CSS, JavaScript\n");

            roadmap.append("\n Intermediate Level:\n");
            roadmap.append("- Learn React / Frontend Frameworks\n");
            roadmap.append("- Learn Backend (Node / Java / APIs)\n");

            roadmap.append("\n Advanced Level:\n");
            roadmap.append("- Build Full Stack Projects\n");
            roadmap.append("- Learn Deployment & Hosting\n");

            roadmap.append("\n Final Step:\n");
            roadmap.append("- Create Portfolio Website & Apply\n");
        }

        else {
            roadmap.append("\n Step 1:\n- Identify required skills for your goal\n");
            roadmap.append("\n Step 2:\n- Learn fundamentals\n");
            roadmap.append("\n Step 3:\n- Build projects\n");
            roadmap.append("\n Step 4:\n- Gain experience & apply\n");
        }

        roadmap.append("\n====================================\n");
        roadmap.append("Tip: Consistency > Speed. Keep learning daily \n");
        return roadmap.toString();
    }
}