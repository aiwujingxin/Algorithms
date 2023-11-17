package leetcode.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 22:34
 */
public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});

            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index] = queue.poll()[0];
            index++;
        }
        return res;
    }
}
