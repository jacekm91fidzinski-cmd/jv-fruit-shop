package strategy;
import java.util.Map;
import model.FruitTransaction;
import service.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        if (handlers == null) {
            throw new IllegalArgumentException("Handlers map cannot be null");
        }
        this.handlers = handlers;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }

        OperationHandler handler = handlers.get(transaction.getOperation());
        if (handler == null) {
            throw new IllegalStateException(
                    "No handler for operation: " + transaction.getOperation());
        }
        handler.apply(transaction);
    }
}
