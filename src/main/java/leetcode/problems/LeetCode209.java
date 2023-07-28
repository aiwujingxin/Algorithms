package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/23 15:58
 */
public class LeetCode209 {

    //11
    //[1,1,1,1,1,1,1,1]
    public static void main(String[] args) {
        System.out.println(new LeetCode209().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }


    //https://leetcode.com/problems/minimum-size-subarray-sum/discuss/365459/Java-Binary-Search-Solution
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int target = s + sum[i];
            int border = binarySearch(target, 0, n, sum);
            if (border > 0) {
                res = Math.min(res, border - i);
            }
        }
        return (res != Integer.MAX_VALUE ? res : 0);
    }

    //find the index of first element that is bigger than or equals target
    public int binarySearch(int target, int beg, int end, int[] nums) {
        int left = beg;
        int right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (right == nums.length - 1 && nums[right] < target) {
            return -1;
        }
        return right;
    }
}
