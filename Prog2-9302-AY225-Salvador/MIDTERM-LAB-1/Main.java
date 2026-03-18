import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<DataRecord> records = new ArrayList<>();

        while (true) {

            try {

                System.out.print("Enter dataset file path: ");
                String path = scanner.nextLine();

                File file = new File(path);

                if (!file.exists() || !file.canRead()) {
                    System.out.println("Error: File not found or cannot be read.");
                    continue;
                }

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));

                String line;

                records.clear();

                br.readLine(); // Skip header

                while ((line = br.readLine()) != null) {

                    try {

                        String[] parts = line.split(",");

                        if (parts.length < 2) continue;

                        String name = parts[0].trim();

                        String raw = parts[parts.length - 1]
                                .replaceAll("[^0-9.]", "");

                        if (raw.isEmpty()) continue;

                        double sales = Double.parseDouble(raw);

                        if (sales <= 0 || sales > 10000) continue;

                        records.add(new DataRecord(name, sales));

                    } catch (Exception ignored) {}
                }

                br.close();

                if (records.size() > 0) break;

                System.out.println("Dataset invalid or empty.");

            } catch (Exception e) {
                System.out.println("File error. Try again.");
            }
        }

        int totalRecords = records.size();

        double totalSales = SalesAnalyzer.totalSales(records);
        double highest = SalesAnalyzer.highestSale(records);
        double lowest = SalesAnalyzer.lowestSale(records);

        double average = totalRecords == 0 ? 0 : totalSales / totalRecords;

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println("\n===== SALES SUMMARY REPORT =====");
        System.out.println("Total Records: " + totalRecords);
        System.out.println("Total Revenue: " + currency.format(totalSales));
        System.out.println("Average Sales: " + currency.format(average));
        System.out.println("Highest Transaction: " + currency.format(highest));
        System.out.println("Lowest Transaction: " + currency.format(lowest));
        System.out.println("=================================");

        scanner.close();
    }
}