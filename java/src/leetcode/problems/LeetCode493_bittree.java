package leetcode.problems;

import knowledge.advstructure.BITree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jingxinwu
 * @date 2022-01-31 2:29 PM
 * @description 离散化
 * @see LeetCode327_BitTree
 */
public class LeetCode493_bittree {

    public int reversePairs(int[] nums) {
        Set<Long> allNumbers = new TreeSet<>();
        for (int x : nums) {
            allNumbers.add((long) x);
            allNumbers.add((long) x * 2);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<>();
        int idx = 0;
        for (long x : allNumbers) {
            values.put(x, idx);
            idx++;
        }

        int ret = 0;
        BITree bit = new BITree(values.size());
        for (int num : nums) {
            int left = values.get((long) num * 2), right = values.size() - 1;
            ret += bit.sum(right + 1) - bit.sum(left + 1);
            bit.add(values.get((long) num) + 1, 1);
        }
        return ret;
    }
}
