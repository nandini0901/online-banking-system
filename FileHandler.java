import java.io.*;

public class FileHandler {
    private static final String FILE_NAME = "bank_data.txt";

    // Saves the current balance to a file
    public static void saveBalance(double balance) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println(balance);
        } catch (IOException e) {
            System.out.println("⚠️ Error saving data to file.");
        }
    }

    // Loads the balance from the file when the program starts
    public static double loadBalance() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            if (line != null) {
                return Double.parseDouble(line);
            }
        } catch (IOException | NumberFormatException e) {
            // If file doesn't exist, return a default initial balance
            return 1000.0;
        }
        return 1000.0;
    }
}
