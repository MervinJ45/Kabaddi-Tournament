package study.studygenerics;

import java.util.HashMap;
import java.util.Map;

public class GenericMap<T, U> {
    private HashMap<T, U> map;

    GenericMap() {
        map = new HashMap<>();
    }

    public void put(T t, U u) {
        map.put(t, u);
    }

    public Map<T, U> getMap() {
        return map;
    }
}
