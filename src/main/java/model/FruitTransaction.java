package model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quanity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quanity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuanity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public static Operation fromCode(String code) {
            for (Operation value : values()) {
                if (value.code.equals(code)) {
                    return value;
                }
            }
            throw new RuntimeException("Unknown operation: " + code);
        }
    }
}
