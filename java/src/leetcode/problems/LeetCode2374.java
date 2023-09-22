package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 23:06
 */
public class LeetCode2374 {

    public int edgeScore(int[] edges) {
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i], map.getOrDefault(edges[i], 0L) + i);
        }
        List<Map.Entry<Integer, Long>> res = new ArrayList<>(map.entrySet());
        res.sort(new Comparator<Map.Entry<Integer, Long>>() {
            @Override
            public int compare(Map.Entry<Integer, Long> entry1, Map.Entry<Integer, Long> entry2) {
                if (!Objects.equals(entry1.getValue(), entry2.getValue())) {
                    return entry2.getValue().compareTo(entry1.getValue());
                }
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });
        return res.get(0).getKey();
    }

    public int edgeScore_fast(int[] edges) {
        int len = edges.length;
        long[] count = new long[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            count[edges[i]] += i;
        }
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (count[i] > max) {
                res = i;
                max = count[i];
            }
        }
        return res;
    }
}
