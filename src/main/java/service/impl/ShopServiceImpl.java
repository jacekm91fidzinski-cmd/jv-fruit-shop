package service.impl;

import java.util.List;
import java.util.Map;
import db.Storage;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        if (strategy == null) {
            throw new RuntimeException("Strategy cannot be null");
        }
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new RuntimeException("Transactions cannot be null");
        }

        for (FruitTransaction transaction : transactions) {
            strategy.handle(transaction);
        }
        return Storage.getFruits();
    }
}
