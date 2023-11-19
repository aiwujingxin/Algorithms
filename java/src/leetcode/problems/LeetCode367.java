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
            if (mid * mid <= num) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right * right == num;
    }
}
