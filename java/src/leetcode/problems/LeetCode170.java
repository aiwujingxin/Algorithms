package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 16:05
 */
public class LeetCode170 {

    class TwoSum {

        HashMap<Integer, Integer> m = new HashMap<>();

        public void add(int n) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        public boolean find(int v) {
            for (int k : m.keySet()) {
                int t = v - k;
                if (m.containsKey(t)) {
                    if (t != k || m.get(k) > 1) return true;
                }
            }
            return false;
        }
    }
}
