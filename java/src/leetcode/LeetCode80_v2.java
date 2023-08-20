package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/10 15:31
 */
public class LeetCode80_v2 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        // loc-2  loc-1  _idx      loc
        //                        idx
        int loc = 2;
        for (int idx = 2; idx < nums.length; idx++) {
            if (!(nums[loc - 1] == nums[loc - 2] && nums[loc - 1] == nums[idx])) {
                nums[loc++] = nums[idx];
            }
        }

        return loc;
    }
}
