package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2022-02-18 11:41 AM
 */
public class LeetCode34_fix {


    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }

        int left = 0;
        int right = nums.length - 1;
        //fix =号
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                int i = mid;

                //fix i > 0
                while (i > 0 && nums[i - 1] == nums[i]) {
                    i--;
                }
                int j = mid;
                //fix j < nums.length - 1
                while (j < nums.length - 1 && nums[j + 1] == nums[j]) {
                    j++;
                }
                return new int[]{i, j};
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

}
