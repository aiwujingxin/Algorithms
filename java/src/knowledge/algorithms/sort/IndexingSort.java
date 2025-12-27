package knowledge.algorithms.sort;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/26 16:12
 * @description indexing sort 原址排序 当数字只在[1-n] 可以使用该方法排序
 * @see LeetCode268
 * @see LeetCode41
 * @see LeetCode287
 * @see LeetCode442
 * @see LeetCode448
 * @see LeetCode645
 * @see LeetCode2471
 * LeetCode2459
 */
public class IndexingSort {

    public void firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

