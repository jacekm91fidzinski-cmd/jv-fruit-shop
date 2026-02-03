package strategy;
import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getFruits()
                .put(transaction.getFruit(), transaction.getQuantity());
    }
}
