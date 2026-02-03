package strategy;

import model.FruitTransaction;
import service.OperationHandler;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        handlers.get(transaction.getOperation()).apply(transaction);
    }
}
