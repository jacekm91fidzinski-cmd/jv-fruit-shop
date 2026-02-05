package basesyntax.db;

import java.util.LinkedHashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> FRUITS = new LinkedHashMap<>();

    private Storage() {
    }

    public static Map<String, Integer> getFruits() {
        return FRUITS;
    }

    public static void clear() {
        FRUITS.clear();
    }
}
