package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-10-10 2:11 下午
 */
public class LeetCode260 {

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int one = 0;
        int two = 0;
        int xorsum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xorsum = xorsum ^ nums[i];
        }
        int bit = xorsum & -xorsum;
        //两个数在这一位上不一样，则两个被分成了两组
        for (int num : nums) {
            if ((num & bit) != 0) {
                one ^= num;
            } else {
                two ^= num;
            }
        }
        return new int[]{one, two};
    }

}
