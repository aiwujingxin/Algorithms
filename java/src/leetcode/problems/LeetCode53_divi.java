package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/12 12:58
 */
public class LeetCode53_divi {

    //https://leetcode.com/problems/maximum-subarray/discuss/1842349/Java-Divide-and-Conquer-and-Kadane's-algorithm

    //推广至线段树
    //https://leetcode.cn/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int pivot = left + (right - left) / 2;
        int lSS = maxSubArray(nums, left, pivot);
        int rSS = maxSubArray(nums, pivot + 1, right);
        int cSS = findCSS(nums, left, pivot, right);
        return Math.max(lSS, Math.max(rSS, cSS));
    }

    private int findCSS(int[] nums, int left, int pivot, int right) {
        int lSum = 0, lMax = Integer.MIN_VALUE;
        for (int i = pivot; i >= left; i--) {
            lSum += nums[i];
            lMax = Math.max(lMax, lSum);
        }
        int rSum = 0, rMax = Integer.MIN_VALUE;
        for (int i = pivot + 1; i <= right; i++) {
            rSum += nums[i];
            rMax = Math.max(rMax, rSum);
        }
        return lMax + rMax;
    }
}
