package knowledge.algorithms.sort.selection;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @see leetcode.problems.LeetCode347 前K个高频元素 https://leetcode.cn/problems/top-k-frequent-elements/description/
 * @see leetcode.problems.LeetCode215 数组中的第K个最大元素  https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public interface TopK {
    int findKthLargest(int[] nums, int k);
}
