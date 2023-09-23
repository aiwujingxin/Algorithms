package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 12:18
 */
public class LCR4 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int n : nums) {
                total += (n >> i & 1);
            }
            if (total % 3 != 0) {
                ans |= 1 << i;
            }
        }
        return ans;

    }
}
