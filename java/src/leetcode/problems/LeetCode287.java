package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 00:35
 */
public class LeetCode287 {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int left = 1, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(mid, nums)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int mid, int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num <= mid) {
                cnt++;
            }
        }
        return cnt <= mid;
    }
}
