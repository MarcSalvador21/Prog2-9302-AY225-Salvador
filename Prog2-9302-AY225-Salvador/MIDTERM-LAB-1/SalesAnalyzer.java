import java.util.*;

public class SalesAnalyzer {

    public static double totalSales(List<DataRecord> list) {
        double sum = 0;

        for (DataRecord r : list) {
            sum += r.getSales();
        }

        return sum;
    }

    public static double highestSale(List<DataRecord> list) {
        double max = 0;

        for (DataRecord r : list) {
            if (r.getSales() > max)
                max = r.getSales();
        }

        return max;
    }

    public static double lowestSale(List<DataRecord> list) {
        if (list.isEmpty()) return 0;

        double min = list.get(0).getSales();

        for (DataRecord r : list) {
            if (r.getSales() < min)
                min = r.getSales();
        }

        return min;
    }
}