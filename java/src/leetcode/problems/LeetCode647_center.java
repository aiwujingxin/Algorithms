package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2022-03-11 4:45 PM
 */
public class LeetCode647_center {

    int count = 0;

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            count += helper(s, i, i);
            count += helper(s, i, i + 1);
        }
        return count;
    }

    private int helper(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }
        return count;
    }
}
