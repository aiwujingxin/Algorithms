package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/19/25 00:22
 */
public class LeetCode2348 {

    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int count = 0; // 当前连续 0 的长度
        for (int num : nums) {
            if (num == 0) {
                count++;
            } else {
                ans += (long) count * (count + 1) / 2;
                count = 0;
            }
        }
        ans += (long) count * (count + 1) / 2; // 处理末尾连续 0
        return ans;
    }
}
