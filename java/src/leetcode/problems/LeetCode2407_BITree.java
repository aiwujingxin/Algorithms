package leetcode.problems;

import knowledge.datastructure.adv.BITree_RangeMax;

/**
 * @author wujingxinit@outlook.com
 * @date 10/21/25 22:14
 */
public class LeetCode2407_BITree {

    public int lengthOfLIS(int[] nums, int k) {
        int U = 0;
        for (int v : nums) U = Math.max(U, v);
        BITree_RangeMax fw = new BITree_RangeMax(U + 2);
        int ans = 0;
        for (int v : nums) {
            long bestPrev = fw.rangeMax(Math.max(1, v - k), v - 1);
            long cur = bestPrev + 1;
            fw.updateMax(v, cur);
            if (cur > ans) ans = (int) cur;
        }
        return ans;
    }
}
