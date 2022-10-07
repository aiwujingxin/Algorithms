package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 13:02
 */
public class LeetCode169 {

    //study
    //https://www.youtube.com/watch?v=2s7b0zs4Vf4
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
