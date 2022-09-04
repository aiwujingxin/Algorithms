package interview.jove;

/**
 * @author jingxinwu
 * @date 2021-12-23 7:07 PM
 */

/**
 * 第四题： 返回最小的 第K个 元素
 */
public class Number04 {

    public static void main(String[] args) {
        System.out.println(new Number04().kMin(new int[]{1, 2, 8, 9, 3, 4, 5, 6, 7, -1}, 9));
    }

    public int kMin(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        return helper(nums, 0, nums.length - 1, k);
    }

    public int helper(int[] nums, int low, int high, int k) {
        int index = part(nums, low, high);
        if (index + 1 == k) {
            return nums[index];
        } else if (index + 1 > k) {
            return helper(nums, low, index - 1, k);
        } else {
            return helper(nums, index + 1, high, k);
        }
    }

    public int part(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && (nums[high] >= temp)) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
}