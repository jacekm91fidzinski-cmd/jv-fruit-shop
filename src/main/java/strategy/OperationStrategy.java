package strategy;

import model.FruitTransaction;

public interface OperationStrategy {
    void handle(FruitTransaction transaction);
}
