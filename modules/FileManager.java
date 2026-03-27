package modules;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static void save(String type, String text) {

        String fileName = "";
        switch (type) {
            case "resume":
                fileName = "resume.txt";
                break;
            case "dm":
                fileName = "dm.txt";
                break;
            case "analysis":
                fileName = "analysis.txt";
                break;
            case "roadmap":
                fileName = "roadmap.txt";
                break;
            case "job":
                fileName = "jobmatch.txt";
                break;
            default:
                fileName = "history.txt";
        }
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(text + "\n-------------------\n");
            writer.close();
        } 
        catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }
}