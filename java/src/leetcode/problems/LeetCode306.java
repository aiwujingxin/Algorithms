package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 12:50
 */
public class LeetCode306 {

    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                if (backtrack(num, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(String num, int index, int first, int second) {
        if (second == num.length()) {
            return true;
        }
        if (num.charAt(index) == '0' && (first - index) > 1) {
            return false;
        }
        if (num.charAt(first) == '0' && (second - first) > 1) {
            return false;
        }
        long a = Long.parseLong(num.substring(index, first));
        long b = Long.parseLong(num.substring(first, second));
        for (int k = second + 1; k <= num.length(); k++) {
            if (num.charAt(second) == '0' && (k - second) > 1) {
                continue;
            }
            long c = Long.parseLong(num.substring(second, k));
            if (c > a + b) {
                return false;
            }
            if (a + b == c) {
                boolean res = backtrack(num, first, second, k);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }
}
