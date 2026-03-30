import java.util.*;
import java.io.*;

import modules.DMGenerator;
import modules.ResumeEnhancer;
import modules.SkillAnalyzer;
import modules.ResumeScorer;
import modules.JobMatcher;
import modules.RoadmapGenerator;
import modules.FileManager;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> history = loadFromFile();

        // Welcome Screen
        printDivider();
        typePrint("Welcome to PathNova ");
        typePrint("Your Personal Career Intelligence System");
        printDivider();
        

        while (true) {

            printDivider();
            System.out.println("        PathNova Pro - Career System");
            printDivider();
            System.out.println("1. Resume Improver");
            System.out.println("2. Resume Scorer");
            System.out.println("3. Job Matcher");
            System.out.println("4. DM Generator");
            System.out.println("5. Career Roadmap");
            System.out.println("6. Skill Gap Analyzer");
            System.out.println("7. View History");
            System.out.println("8. Exit");
            printDivider();

            System.out.print("Please enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            //  Resume Improver
            if (choice == 1) {
                System.out.print("Enter your sentence: ");
                String input = sc.nextLine();

                showLoading();
                String improved = ResumeEnhancer.improve(input);

                printDivider();
                System.out.println("RESUME IMPROVEMENT RESULT");
                printDivider();
                System.out.println(improved);
                printDivider();

                history.add(improved);
                FileManager.save("resume", improved);
            }

            //  Resume Scorer
            else if (choice == 2) {
                System.out.print("Enter your resume line: ");
                String input = sc.nextLine();

                showLoading();
                String result = ResumeScorer.score(input);

                printDivider();
                System.out.println("RESUME SCORE");
                printDivider();
                System.out.println(result);
                printDivider();

                history.add(result);
                FileManager.save("analysis", result);
            }

            //  Job Matcher
            else if (choice == 3) {
                System.out.print("Enter your resume text: ");
                String resume = sc.nextLine();

                System.out.print("Enter job description: ");
                String jobDesc = sc.nextLine();

                showLoading();
                String result = JobMatcher.match(resume, jobDesc);

                printDivider();
                System.out.println("JOB MATCH ANALYSIS");
                printDivider();
                System.out.println(result);
                printDivider();

                history.add(result);
                FileManager.save("job", result);
            }

            //  DM Generator
            else if (choice == 4) {
                System.out.print("Enter person's name: ");
                String name = sc.nextLine();

                System.out.print("Enter field: ");
                String field = sc.nextLine();

                showLoading();
                String message = DMGenerator.generate(name, field);

                printDivider();
                System.out.println("GENERATED DM");
                printDivider();
                System.out.println(message);
                printDivider();

                history.add(message);
                FileManager.save("dm", message);
            }

            //  Career Roadmap
            else if (choice == 5) {
                System.out.print("Enter your career goal: ");
                String goal = sc.nextLine();

                showLoading();
                String roadmap = RoadmapGenerator.generate(goal);

                printDivider();
                System.out.println("CAREER ROADMAP");
                printDivider();
                System.out.println(roadmap);
                printDivider();

                history.add(roadmap);
                FileManager.save("roadmap", roadmap);
            }

            //  Skill Analyzer
            else if (choice == 6) {
                System.out.print("Enter your goal: ");
                String goal = sc.nextLine();

                System.out.print("Enter your skills (comma separated): ");
                String skills = sc.nextLine();

                showLoading();
                String analysis = SkillAnalyzer.analyze(goal, skills);

                printDivider();
                System.out.println("SKILL ANALYSIS");
                printDivider();
                System.out.println(analysis);
                printDivider();

                history.add(analysis);
                FileManager.save("analysis", analysis);
            }

            // View History
            else if (choice == 7) {
                showLoading();

                printDivider();
                System.out.println("HISTORY");
                printDivider();

                if (history.isEmpty()) {
                    System.out.println("No history available.");
                } else {
                    for (String item : history) {
                        System.out.println("----------------------------");
                        System.out.println(item);
                    }
                }

                printDivider();
            }

            //Exit
            else if (choice == 8) {
                System.out.println("\nThank you for using PathNova Pro 🚀");
                break;
            }

            //invalid
            else {
                System.out.println("Invalid choice. Try again!");
            }

            // Pause
            System.out.println("\nPress Enter to continue...");
            sc.nextLine();
        }

        sc.close();
    }

    //Loading history
    public static ArrayList<String> loadFromFile() {
        ArrayList<String> history = new ArrayList<>();

        try {
            File file = new File("history.txt");

            if (file.exists()) {
                Scanner reader = new Scanner(file);

                while (reader.hasNextLine()) {
                    history.add(reader.nextLine());
                }

                reader.close();
            }
        } catch (Exception e) {
            System.out.println("No previous history found.");
        }

        return history;
    }

    //UI Helpers
    public static void printDivider() {
        System.out.println("========================================");
    }

    public static void typePrint(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(8);
            } catch (Exception e) {}
        }
        System.out.println();
    }

    public static void showLoading() {
        System.out.print("Processing");
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(300);
            } catch (Exception e) {}
        }
        System.out.println();
    }
}