package service.impl;

import db.Storage;
import service.ReportGenerator;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : Storage.getFruits().entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return builder.toString();
    }
}
