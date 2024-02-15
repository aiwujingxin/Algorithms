package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/8 15:36
 */
public class LeetCode2997 {

    public int minOperations(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int t = 0;
            for (int num : nums) {
                t += (num >> i) & 1;
            }
            if (t % 2 == 0 && ((k >> i) & 1) == 1) {
                res++;
            }
            if (t % 2 == 1 && ((k >> i) & 1) == 0) {
                res++;
            }
        }
        return res;
    }
}
