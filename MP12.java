import java.io.*;
import java.util.*;

public class MP12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter CSV file path: ");
        String filePath = input.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String[]> rows = new ArrayList<>();
            String line;
            int[] colWidths = null;

            // Read all rows
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1); // keep empty values
                rows.add(values);

                // Update column widths
                if (colWidths == null) {
                    colWidths = new int[values.length];
                    for (int i = 0; i < values.length; i++) colWidths[i] = values[i].length();
                } else {
                    for (int i = 0; i < values.length; i++)
                        if (values[i].length() > colWidths[i])
                            colWidths[i] = values[i].length();
                }
            }

            // Print formatted table
            for (String[] row : rows) {
                for (int i = 0; i < row.length; i++) {
                    System.out.print(String.format("%-" + colWidths[i] + "s  ", row[i]));
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}