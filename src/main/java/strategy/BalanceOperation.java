package strategy;

import service.OperationHandler;
import db.Storage;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getFruits().put(transaction.getFruit(), transaction.getQuanity());
    }
}
