package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/31 00:28
 */
public class LeetCode128_bfs_TEL {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int res = 0;
        while (!set.isEmpty()) {
            Iterator<Integer> itr = set.iterator();
            res = Math.max(res, bfs(set, itr.next()));
        }
        return res;
    }

    private int bfs(Set<Integer> set, Integer num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        set.remove(num);
        int length = 1;
        while (!queue.isEmpty()) {

            Integer i = queue.poll();
            int[] dirs = new int[]{i - 1, i + 1};
            for (int next : dirs) {
                if (set.contains(next)) {
                    queue.add(next);
                    set.remove(next);
                    length++;
                }
            }
        }
        return length;
    }
}
