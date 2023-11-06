package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 14:03
 * @see LeetCode229
 */
public class LeetCode169 {

    //摩尔投票法：摩尔投票法的核心思想为对拼消耗。
    //每次从序列里选择两个不相同的数字删除掉（或称为「抵消」），最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个元素。
    //https://www.youtube.com/watch?v=2s7b0zs4Vf4&t=195s
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
            }
            if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}
