package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null) {
            throw new RuntimeException("Input lines cannot be null");
        }

        return lines.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    if (parts.length != 3) {
                        throw new RuntimeException("Invalid line: " + line);
                    }

                    int quantity = Integer.parseInt(parts[2]);
                    if (quantity < 0) {
                        throw new RuntimeException("Quantity cannot be negative: " + line);
                    }

                    return new FruitTransaction(
                            FruitTransaction.Operation.fromCode(parts[0]),
                            parts[1],
                            quantity
                    );
                })
                .collect(Collectors.toList());
    }
}
