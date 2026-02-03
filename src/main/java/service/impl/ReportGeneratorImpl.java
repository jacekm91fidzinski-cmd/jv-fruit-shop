package service.impl;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport(Map<String, Integer> fruitData) {
        if (fruitData == null) {
            throw new IllegalArgumentException("Fruit data cannot be null");
        }

        StringBuilder builder = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : fruitData.entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return builder.toString();
    }
}
