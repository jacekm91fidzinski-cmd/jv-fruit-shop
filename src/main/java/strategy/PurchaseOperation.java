package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int current = Storage.getFruits().getOrDefault(transaction.getFruit(), 0);
        int result = current - transaction.getQuanity();
        if (result < 0) {
            throw new RuntimeException("Not enough fruits: " + transaction.getFruit());
        }
        Storage.getFruits().put(transaction.getFruit(), result);
    }
}
