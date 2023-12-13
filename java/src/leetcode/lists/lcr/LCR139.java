package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 21:39
 */
public class LCR139 {

    public int[] exchange(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int slow = 0;

        while (slow < nums.length) {
            if (nums[slow] % 2 == 1) {
                slow++;
            } else {
                int fast = slow + 1;
                while (fast < nums.length && nums[fast] % 2 == 0) {
                    fast++;
                }
                if (fast == nums.length) {
                    return nums;
                }
                int t = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = t;
            }
        }
        return nums;
    }

    public int[] exchange_fast(int[] nums) {
        //纯自己做出来的 用双指针进行求解
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] % 2 == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            } else {
                i++;
            }
        }
        return nums;
    }
}
