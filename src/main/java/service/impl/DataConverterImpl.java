package service.impl;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("Input lines cannot be null");
        }

        List<FruitTransaction> result = new ArrayList<>();
        int lineNumber = 1;

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException(
                        "Invalid CSV format at line " + lineNumber + ": " + line);
            }

            try {
                String operationCode = parts[0].trim();
                String fruit = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());

                if (quantity < 0) {
                    throw new IllegalArgumentException(
                            "Negative quantity at line " + lineNumber + ": " + line);
                }

                result.add(new FruitTransaction(
                        FruitTransaction.Operation.fromCode(operationCode),
                        fruit,
                        quantity
                ));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "Invalid quantity at line " + lineNumber + ": " + line, e);
            }

            lineNumber++;
        }
        return result;
    }
}
