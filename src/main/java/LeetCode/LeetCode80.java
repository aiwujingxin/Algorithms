package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-06-26 2:33 下午
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    //简洁的版本
    public int removeDuplicatesV2(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums.length;
        }
        int loc = 2;
        for (int idx = 2; idx < nums.length; idx++) {
            if (!(nums[loc - 1] == nums[loc - 2] && nums[loc - 1] == nums[idx])) {
                nums[loc++] = nums[idx];
            }
        }

        return loc;
    }
}
