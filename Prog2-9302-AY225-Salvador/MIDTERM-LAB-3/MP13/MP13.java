import java.io.*;
import java.util.*;

public class MP13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter CSV file path: ");
        String filePath = input.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowNum = 0;

            while ((line = br.readLine()) != null) {
                rowNum++;
                String[] values = line.split(",", -1); // keep empty cells
                boolean hasMissing = false;
                for (String val : values) {
                    if (val.trim().isEmpty()) {
                        hasMissing = true;
                        break;
                    }
                }

                if (hasMissing) {
                    System.out.print("Row " + rowNum + ": ");
                    System.out.println(String.join(" | ", values));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}