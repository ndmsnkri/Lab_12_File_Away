import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {
    public static void main(String[] args) {
        // Create a JFileChooser dialog
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // The user selected a file
            File selectedFile = fileChooser.getSelectedFile();

            // Process the selected file and print the summary report
            processFile(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }

    public static void processFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            while ((line = reader.readLine()) != null) {
                // Count lines
                lineCount++;

                // Count words
                String[] words = line.split("\\s+");
                wordCount += words.length;

                // Count characters
                charCount += line.length();
            }

            // Print the summary report
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
