package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:36
 */
public class LeetCode1560 {

    int n;

    public List<Integer> mostVisited(int n, int[] rounds) {
        this.n = n;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = 1;
        map.put(rounds[0], map.getOrDefault(rounds[0], 0) + 1);
        for (int i = 1; i < rounds.length; i++) {
            int start = rounds[i - 1];
            int end = rounds[i];
            while (start != end) {
                start = getNext(start);
                map.put(start, map.getOrDefault(start, 0) + 1);
                max = Math.max(max, map.get(start));
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private int getNext(int start) {
        if (start == n) {
            return 1;
        }
        return start + 1;
    }
}
