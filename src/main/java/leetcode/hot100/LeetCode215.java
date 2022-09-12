package leetcode.hot100;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/12 23:33
 */
public class LeetCode215 {


    //https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = part(nums, left, right);
            if (index + 1 == k) {
                return nums[index];
            } else if (index + 1 < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }

    private int part(int[] nums, int i, int j) {
        int h = nums[i];
        while (i < j) {
            while (nums[j] <= h && i < j) {
                j--;
            }
            nums[i] = nums[j];
            while (nums[i] >= h && i < j) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = h;
        return i;
    }
}
