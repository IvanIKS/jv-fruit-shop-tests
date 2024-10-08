package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> storage, FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException(String.format("Error supplying "
                    + "fruit %s: quantity %d of supply is less than zero", fruit, quantity));
        }
        int newQuantity = (storage.get(fruit) == null)
                ? quantity
                : storage.get(fruit) + quantity;
        storage.put(fruit, newQuantity);
    }
}
