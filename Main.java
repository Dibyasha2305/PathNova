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

        while (true) {
            System.out.println("\n--------------------------------------");
            System.out.println("      PathNova Pro - Career System       ");
            System.out.println("-----------------------------------------");
            System.out.println("1. Resume Improver");
            System.out.println("2. Resume Scorer");
            System.out.println("3. Job Matcher");
            System.out.println("4. DM Generator");
            System.out.println("5. Career Roadmap");
            System.out.println("6. Skill Gap Analyzer");
            System.out.println("7. View History");
            System.out.println("8. Exit");
            System.out.println("-----------------------------------------");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter your sentence: ");
                String input = sc.nextLine();

                String improved = ResumeEnhancer.improve(input);

                System.out.println("\n---------- RESULT -----------");
                System.out.println(improved);
                System.out.println("-------------------------------");

                history.add(improved);
                FileManager.save("resume", improved);
            }

            else if (choice == 2) {
                System.out.print("Enter your resume line: ");
                String input = sc.nextLine();

                String result = ResumeScorer.score(input);

                System.out.println("\n----------- SCORE ----------");
                System.out.println(result);
                System.out.println("------------------------------");

                history.add(result);
                FileManager.save("analysis", result);
            }

            else if (choice == 3) {
                System.out.print("Enter your resume text: ");
                String resume = sc.nextLine();

                System.out.print("Enter job description: ");
                String jobDesc = sc.nextLine();

                String result = JobMatcher.match(resume, jobDesc);
                System.out.println("\n---------- MATCH RESULT ---------");
                System.out.println(result);
                System.out.println("------------------------------------");

                history.add(result);
                FileManager.save("job", result);
            }
            
            else if (choice == 4) {
                System.out.print("Enter person's name: ");
                String name = sc.nextLine();

                System.out.print("Enter field: ");
                String field = sc.nextLine();
                String message = DMGenerator.generate(name, field);

                System.out.println("\n--------- GENERATED DM --------");
                System.out.println(message);
                System.out.println("----------------------------------");

                history.add(message);
                FileManager.save("dm", message);
            }
            else if (choice == 5) {
                System.out.print("Enter your career goal: ");
                String goal = sc.nextLine();

                String roadmap = RoadmapGenerator.generate(goal);

                System.out.println("\n---------- ROADMAP ----------");
                System.out.println(roadmap);
                System.out.println("-------------------------------");

                history.add(roadmap);
                FileManager.save("roadmap", roadmap);
            }

            else if (choice == 6) {
                System.out.print("Enter your goal: ");
                String goal = sc.nextLine();

                System.out.print("Enter your skills (comma separated): ");
                String skills = sc.nextLine();

                String analysis = SkillAnalyzer.analyze(goal, skills);

                System.out.println("\n---------- ANALYSIS ----------");
                System.out.println(analysis);
                System.out.println("--------------------------------");

                history.add(analysis);
                FileManager.save("analysis", analysis);
            }

            else if (choice == 7) {
                System.out.println("\n----------- HISTORY -----------");

                if (history.isEmpty()) {
                    System.out.println("No history available.");
                } else {
                    for (String item : history) {
                        System.out.println("----------------------------");
                        System.out.println(item);
                    }
                }

                System.out.println("-----------------------------------------");
            }

            else if (choice == 8) {
                System.out.println("\nThank you for using PathNova Pro!");
                break;
            }
            else {
                System.out.println("Invalid choice. Try again!");
            }
            System.out.println("\nPress Enter to continue...");
            sc.nextLine();
        }sc.close();
    }


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
            System.out.println("No previous history found.");        }

        return history;
    }
}