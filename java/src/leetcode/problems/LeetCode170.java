package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 16:05
 */
public class LeetCode170 {
    class TwoSum {
        HashMap<Integer, Integer> map;

        public TwoSum() {
            map = new HashMap<>();
        }

        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (map.containsKey(value - entry.getKey())) {
                    if (value - entry.getKey() == entry.getKey()) {
                        if (entry.getValue() > 1) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
