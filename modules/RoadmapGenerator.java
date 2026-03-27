package modules;

public class RoadmapGenerator {
    public static String generate(String goal) {
        goal = goal.toLowerCase();
        String roadmap = "\n---------- Career Roadmap ------------\n";

        if (goal.contains("software engineer")) {

            roadmap += "Step 1: Learn Programming Basics (Java/Python)\n";
            roadmap += "Step 2: Master Data Structures & Algorithms\n";
            roadmap += "Step 3: Learn Databases (SQL)\n";
            roadmap += "Step 4: Learn Backend Development (APIs, Spring)\n";
            roadmap += "Step 5: Build Real-world Projects\n";
            roadmap += "Step 6: Practice Interview Questions\n";
            roadmap += "Step 7: Apply for Internships/Jobs\n";
        }

        else if (goal.contains("data scientist")) {

            roadmap += "Step 1: Learn Python & Libraries (NumPy, Pandas)\n";
            roadmap += "Step 2: Learn Statistics & Probability\n";
            roadmap += "Step 3: Learn Machine Learning Algorithms\n";
            roadmap += "Step 4: Work on Data Projects\n";
            roadmap += "Step 5: Learn Data Visualization\n";
            roadmap += "Step 6: Build Portfolio\n";
        }

        else {
            roadmap += "Step 1: Identify required skills\n";
            roadmap += "Step 2: Learn fundamentals\n";
            roadmap += "Step 3: Build projects\n";
            roadmap += "Step 4: Gain practical experience\n";
            roadmap += "Step 5: Apply for opportunities\n";
        }

        roadmap += "-----------------------------------------\n";
        return roadmap;
    }
}