package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2023/11/19 21:10
 */
public class LeetCode367 {

    public boolean isPerfectSquare(int num) {
        long left = 0, right = num;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left * left == num;
    }
}
