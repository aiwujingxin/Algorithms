package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 12/18/25 14:07
 */
public class LeetCode2856 {

    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> cnts = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : map.values()) {
            cnts.offer(count);
        }
        while (cnts.size() > 1) {
            int a = cnts.poll();
            int b = cnts.poll();
            a--;
            b--;
            if (a > 0) cnts.offer(a);
            if (b > 0) cnts.offer(b);
        }
        return cnts.isEmpty() ? 0 : cnts.peek();
    }
}
