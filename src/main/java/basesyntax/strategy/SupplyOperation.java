package basesyntax.strategy;

import basesyntax.db.Storage;
import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getFruits()
                .merge(
                        transaction.getFruit(),
                        transaction.getQuantity(),
                        Integer::sum
                );
    }
}
