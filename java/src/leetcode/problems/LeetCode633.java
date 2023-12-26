package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 18:08
 */
public class LeetCode633 {

    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long mid = left * left + right * right;
            if (mid == (long) c) {
                return true;
            }
            if (mid > (long) c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
