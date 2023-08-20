package leetcode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/29 14:15
 */
public class LeetCode283 {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        new LeetCode283().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

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
