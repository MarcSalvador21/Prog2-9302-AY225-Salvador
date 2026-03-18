import java.io.*;
import java.util.*;

public class MP11_ColumnFrequency {
    public static void main(String[] args) {
        String filePath = "../data.csv"; // CSV in parent folder
        String columnName = "Exam";      // change this to any column you want

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("CSV is empty.");
                return;
            }

            String[] headers = headerLine.split(",");
            int columnIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].trim().equalsIgnoreCase(columnName.trim())) {
                    columnIndex = i;
                    break;
                }
            }
            
            if (columnIndex == -1) {
                System.out.println("Column not found.");
                return;
            }

            Map<String, Integer> frequency = new HashMap<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > columnIndex) {
                    String key = values[columnIndex].trim();
                    frequency.put(key, frequency.getOrDefault(key, 0) + 1);
                }
            }

            System.out.println("Frequency for column \"" + columnName + "\":");
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
    }
}