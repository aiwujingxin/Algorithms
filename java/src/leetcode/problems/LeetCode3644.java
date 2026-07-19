package leetcode.problems;


/**
 * @author wujingxinit@outlook.com
 * @date 7/11/26 16:55
 */
public class LeetCode3644 {

    public int sortPermutation(int[] nums) {
        int ans = -1; // -1 的二进制全是 1，作为按位与的初始值不影响结果
        for (int i = 0; i < nums.length; i++) {
            // 如果元素不在它应该在的位置上
            if (nums[i] != i) {
                ans &= nums[i]; // 将所有错位元素进行按位与
            }
        }
        // 如果 ans 还是 -1，说明所有元素都在正确位置（数组已有序），按题意返回 0
        return Math.max(ans, 0);
    }
}
