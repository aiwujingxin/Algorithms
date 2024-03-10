package leetcode.problems;

import knowledge.advstructure.*;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2022-01-31 2:29 PM
 * @description 离散化
 */
public class LeetCode493_bittree {

    public int reversePairs(int[] nums) {
        Set<Long> set = new TreeSet<>();
        for (int num : nums) {
            set.add((long) num);
            set.add((long) num * 2);
        }
        Map<Long, Integer> map = new HashMap<>();
        int rank = 1;
        for (long num : set) {
            map.put(num, rank++);
        }

        int ret = 0;
        BITree bit = new BITree(map.size());
        for (long num : nums) {
            int left = map.get(num * 2);
            int right = map.size() - 1;
            ret += bit.sum(right + 1) - bit.sum(left);
            bit.add(map.get(num), 1);
        }
        return ret;
    }
}
