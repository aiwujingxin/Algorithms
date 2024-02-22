package leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/23 12:35
 */
public class LeetCode2099 {

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<int[]> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            list.add(new int[]{node[0], node[1]});
        }
        list.sort(Comparator.comparingInt(o -> o[1]));
        int[] res = new int[k];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i)[0];
        }
        return res;
    }
}
