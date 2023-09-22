package leetcode.problems;

import basic.datastructure.advance.BinaryIndexedTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/24 21:53
 */
public class LeetCode327_BitTree {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }

        Set<Long> allNumbers = new TreeSet<>();
        for (long x : preSum) {
            allNumbers.add(x);
            allNumbers.add(x - lower);
            allNumbers.add(x - upper);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<>();
        int idx = 0;
        for (long x : allNumbers) {
            values.put(x, idx);
            idx++;
        }

        int ret = 0;
        BinaryIndexedTree bit = new BinaryIndexedTree(values.size());
        for (long l : preSum) {
            int left = values.get(l - upper), right = values.get(l - lower);
            ret += bit.query(right + 1) - bit.query(left);
            bit.update(values.get(l) + 1, 1);
        }
        return ret;
    }
}
