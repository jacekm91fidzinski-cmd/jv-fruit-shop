package service.impl;

import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions cannot be null");
        }

        Storage.clear();
        for (FruitTransaction transaction : transactions) {
            strategy.handle(transaction);
        }
        return Storage.getFruits();
    }
}
