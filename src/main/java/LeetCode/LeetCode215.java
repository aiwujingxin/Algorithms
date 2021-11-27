package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-06-06 5:31 下午
 */
public class LeetCode215 {

    public static void main(String[] args) {
        LeetCode215 leetCode215 = new LeetCode215();
        int[] b = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(leetCode215.findKthLargest(b, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int hi = nums.length - 1;
        while (true) {
            int pos = helper(nums, low, hi);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                hi = pos - 1;
            } else {
                low = pos + 1;
            }

        }
    }

    private int helper(int[] nums, int low, int hi) {
        int pi = nums[low];
        while (low < hi) {
            while (low < hi && nums[hi] <= pi) {
                hi--;
            }
            nums[low] = nums[hi];
            while (low < hi && nums[low] >= pi) {
                low++;
            }
            nums[hi] = nums[low];
        }
        nums[low] = pi;
        return low;
    }
}
