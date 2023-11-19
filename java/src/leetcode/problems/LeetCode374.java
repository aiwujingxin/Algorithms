package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2023/11/19 21:14
 */
public class LeetCode374 {

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int l = 1;
            int r = n;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (guess(mid) == 0) {
                    return mid;
                }
                if (guess(mid) > 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return -1;
        }
    }

    private class GuessGame {
        public int guess(int b) {
            return 0;
        }
    }
}
