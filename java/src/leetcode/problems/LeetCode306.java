package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2023.11.10 00:05
 */
public class LeetCode306 {

    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                if (dfs(num, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(String num, int start, int end1, int end2) {
        if (num.charAt(start) == '0' && end1 > start + 1 || num.charAt(end1) == '0' && end2 > end1 + 1) {
            return false;
        }
        if (end2 == num.length()) {
            return true;
        }
        long sum = Long.parseLong(num.substring(start, end1)) + Long.parseLong(num.substring(end1, end2));
        for (int end3 = end2 + 1; end3 <= num.length(); end3++) {
            long cur = Long.parseLong(num.substring(end2, end3));
            if (cur > sum) {
                return false;
            }
            if (sum == cur && dfs(num, end1, end2, end3)) {
                return true;
            }
        }
        return false;
    }
}

