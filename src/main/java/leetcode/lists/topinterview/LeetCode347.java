package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/3 17:19
 */
public class LeetCode347 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(new LeetCode347().topKFrequent(new int[]{1, 2}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        //  15 16 19

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});

            } else {
                if (!queue.isEmpty() && queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}

