package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/23 16:00
 */
public class LeetCode169_vote {

    //study
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
