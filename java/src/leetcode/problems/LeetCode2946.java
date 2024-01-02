package leetcode.problems;

import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/2 22:46
 */
public class LeetCode2946 {

    public boolean areSimilar(int[][] mat, int k) {
        int index = 0;
        k = k % mat[0].length;
        for (int[] row : mat) {
            int[] origin = new int[row.length];
            for (int i = 0; i < row.length; i++) {
                origin[i] = row[i];
            }
            if (index % 2 == 0) {
                //左移
                reverse(row, k - 1);
            } else {
                // 右移
                reverse(row, row.length - k - 1); /// k =3 length= 9
            }
            if (!Objects.deepEquals(origin, row)) {
                return false;
            }
            index++;
        }
        return true;
    }

    private void reverse(int[] nums, int k) {
        swap(nums, 0, k);
        swap(nums, k + 1, nums.length - 1);
        swap(nums, 0, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}
