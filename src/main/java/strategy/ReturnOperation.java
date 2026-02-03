package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getFruits()
                .merge(
                        transaction.getFruit(),
                        transaction.getQuantity(),
                        Integer::sum);
    }
}
