package leetcode.lists.LCR;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 22:59
 */
public class LCR60 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LCR60().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(new LCR60().topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6, 6, 6}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
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
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
