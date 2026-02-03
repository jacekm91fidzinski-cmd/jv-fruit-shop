package strategy;

import service.OperationHandler;
import db.Storage;
import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getFruits()
                .merge(
                        transaction.getFruit(),
                        transaction.getQuanity(),
                        Integer::sum
                );
    }
}
