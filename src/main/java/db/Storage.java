package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> FRUITS = new HashMap<>();

    private Storage() {
    }

    public static Map<String, Integer> getFruits() {
        return FRUITS;
    }
}
