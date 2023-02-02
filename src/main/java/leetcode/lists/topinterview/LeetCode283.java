package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/29 14:42
 */
public class LeetCode283 {

    //输入: nums = [0,0,0,3,12]
    //输出:        [1,3,12,0,0]

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int temp = nums[i];
            int j = i;
            while (j > index) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[index] = temp;
            index++;
        }
    }
}
