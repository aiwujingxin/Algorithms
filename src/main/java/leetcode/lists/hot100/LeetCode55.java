package leetcode.lists.hot100;


/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 15:34
 */
public class LeetCode55 {

    public static void main(String[] args) {
        System.out.println(new LeetCode55().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new LeetCode55().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
