package leetcode.problems.lists.lcr;

import knowledge.algorithms.sort.selection.QuickSelect;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 17:44
 */
public class LCR76 {

    public int findKthLargest(int[] nums, int k) {
        return new QuickSelect().findKthLargest(nums, k);
    }
}
