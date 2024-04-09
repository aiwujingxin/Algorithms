package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2023/11/19 21:10
 */
public class LeetCode367 {

    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * mid > num) r = mid - 1;
            else l = mid;
        }
        return l * l == num;
    }
}
