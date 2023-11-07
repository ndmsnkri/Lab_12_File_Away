import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileWriting {

    public static void main(String[] args) {

        ArrayList<String> recs = new ArrayList<>();
        recs.add("Sample data for our file writing example.");
        recs.add("Sample data Line 2.");
        recs.add("Sample data Line 3.");
        recs.add("Sample data Line 4.");
        recs.add("Sample data Line 5.");

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try {

            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String rec : recs) {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
