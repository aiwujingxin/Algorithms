package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 15:32
 */
public class LCR191 {

    public int[] constructArr(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] pre = new int[nums.length];
        pre[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        int t = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            pre[i] = pre[i] * t;
            t = t * nums[i];
        }
        return pre;
    }
}
