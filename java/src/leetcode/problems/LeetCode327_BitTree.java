package leetcode.problems;

import knowledge.datastructure.advanced.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/24 21:53
 */
public class LeetCode327_BitTree {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preSum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        Set<Long> set = new TreeSet<>();
        for (long x : preSum) {
            set.add(x);
            set.add(x - lower);
            set.add(x - upper);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> map = new HashMap<>();
        int rank = 1;
        for (long x : set) {
            map.put(x, rank++);
        }

        int cnt = 0;
        BITree tree = new BITree(map.size());
        for (long sum : preSum) {
            cnt += tree.sum(map.get(sum - lower)) - tree.sum(map.get(sum - upper) - 1);
            tree.add(map.get(sum), 1);
        }
        return cnt;
    }
}
