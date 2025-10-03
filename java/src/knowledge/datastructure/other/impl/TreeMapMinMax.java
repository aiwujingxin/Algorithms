package knowledge.datastructure.other.impl;

import knowledge.datastructure.other.MinMaxContainer;

import java.util.TreeMap;

/**
 * @author wujingxinit@outlook.com
 * @date 8/20/25 10:57
 */

public class TreeMapMinMax implements MinMaxContainer {

    private final TreeMap<Integer, Integer> map = new TreeMap<>();

    public void insert(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    public void remove(int x) {
        if (!map.containsKey(x)) return;
        if (map.get(x) == 1) map.remove(x);
        else map.put(x, map.get(x) - 1);
    }

    public int getMin() {
        return map.firstKey();
    }

    public int getMax() {
        return map.lastKey();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }
}
