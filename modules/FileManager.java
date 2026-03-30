package modules;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

            // Timestamp
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String time = LocalDateTime.now().format(dtf);

            writer.write("=========================================\n");
            writer.write("[" + type.toUpperCase() + "]  " + time + "\n");
            writer.write("----------------------------------------\n");
            writer.write(text + "\n");
            writer.write("=======================================\n\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }
}