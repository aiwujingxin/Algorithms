package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 6/24/26 22:14
 */
public class LeetCode3952 {

    public long maxTotal(int[] nums, String s) {
        long sum = 0;
        int n = nums.length;
        boolean[] f = new boolean[n];
        for (int i = 0; i < n; i++) {
            f[i] = s.charAt(i) == '1';
        }
        int pre0Index = -1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i] && f[i] && !f[i - 1]) {
                f[i - 1] = true;
                f[i] = false;
            } else if (f[i]) {
                if (pre0Index != -1 && nums[pre0Index] > nums[i]) {
                    f[pre0Index] = true;
                    f[i] = false;
                    pre0Index = -1;
                }
            }
            if (!f[i - 1] && f[i]) {
                pre0Index = i - 1;
            } else if (!f[i]) {
                pre0Index = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (f[i])
                sum += nums[i];
        }
        return sum;
    }
}
