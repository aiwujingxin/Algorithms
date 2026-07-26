package leetcode.problems;

import knowledge.datastructure.adv.BIT.BITreeRangeMax;

/**
 * @author wujingxinit@outlook.com
 * @date 10/21/25 22:14
 */
public class LeetCode2407_BITree {

    public int lengthOfLIS(int[] nums, int k) {
        int U = 0;
        for (int v : nums) U = Math.max(U, v);
        BITreeRangeMax fw = new BITreeRangeMax(U + 2);
        int ans = 0;
        for (int v : nums) {
            long bestPrev = v == 1 ? 0 : fw.rangeMax(Math.max(1, v - k), v - 1);
            long cur = bestPrev + 1;
            fw.update(v, cur);
            if (cur > ans) ans = (int) cur;
        }
        return ans;
    }
}
