package leetcode.lists.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 22:32
 */
public class Offer53_II {

    public int missingNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        if (right == nums[right]) {
            return right + 1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid == nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
