package knowledge.algorithms.sort;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description indexing sort 原址排序 当数字只在[1-n] 可以使用该方法排序
 * @see leetcode.problems.LeetCode268
 * @see leetcode.problems.LeetCode41
 * @see leetcode.problems.LeetCode287
 * @see leetcode.problems.LeetCode442
 * @see leetcode.problems.LeetCode448
 * @see leetcode.problems.LeetCode645
 * @see leetcode.problems.LeetCode2471
 * @see leetcode.problems.LeetCode2459
 */
public class IndexingSort {

    public void firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
    }
}

