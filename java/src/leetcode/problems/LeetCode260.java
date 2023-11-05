package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 16:44
 */
public class LeetCode260 {

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int one = 0;
        int two = 0;
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n = n ^ nums[i];
        }
        int bit = n & -n;  // 取出最后一个1
        //两个数在这一位上不一样，则被分成了两组
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
