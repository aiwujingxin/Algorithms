package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/23 16:00
 * @see LeetCode229_vote
 */
public class LeetCode169_vote {

    //摩尔投票法：摩尔投票法的核心思想为对拼消耗。
    //每次从序列里选择两个不相同的数字删除掉（或称为「抵消」），最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个元素。
    //https://www.youtube.com/watch?v=2s7b0zs4Vf4&t=195s
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (num != res) {
                count--;
            } else {
                count++;
            }
        }
        return res;
    }
}
