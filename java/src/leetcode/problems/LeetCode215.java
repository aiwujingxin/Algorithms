package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2022-02-16 4:26 PM
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = part(nums, left, right);
            if (index + 1 == k) {
                return nums[index];//fix
            } else if (index + 1 < k) {
                left = index + 1;//fix
            } else {
                right = index - 1;//fix
            }
        }
        return -1;
    }

    private int part(int[] nums, int i, int j) {
        int pi = nums[i];
        while (i < j) {

            while (i < j && nums[j] <= pi) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] >= pi) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pi;
        return i;
    }

}
