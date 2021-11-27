package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-08-04 11:58 下午
 */
public class LeetCode153 {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}
