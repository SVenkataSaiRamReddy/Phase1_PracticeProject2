import java.io.*;

public class FileCRUDOperations {

    public static void main(String[] args) {
        // File path
        String filePath = "sample.txt";

        // Create a file
        createFile(filePath);

        // Write content to the file
        String content = "Hello, this is a sample content.";
        writeFile(filePath, content);

        // Read content from the file
        String readContent = readFile(filePath);
        System.out.println("Content read from the file: " + readContent);

        // Update content in the file
        String updatedContent = "Updated content in the file.";
        updateFile(filePath, updatedContent);

        // Read updated content from the file
        String updatedReadContent = readFile(filePath);
        System.out.println("Updated content read from the file: " + updatedReadContent);

        // Delete the file
        deleteFile(filePath);
    }

    // Create a file
    public static void createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            System.out.println(e.getMessage());
        }
    }

    // Write content to the file
    public static void writeFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Content written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            System.out.println(e.getMessage());
        }
    }

    // Read content from the file
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            System.out.println(e.getMessage());
        }
        return content.toString();
    }

    // Update content in the file
    public static void updateFile(String filePath, String updatedContent) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(updatedContent);
            System.out.println("Content updated in the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the file.");
            System.out.println(e.getMessage());
        }
    }

    // Delete the file
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
