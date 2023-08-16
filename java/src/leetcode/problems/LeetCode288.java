package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/12 16:23
 */
public class LeetCode288 {

    private String[] dict;

    public void ValidWordAbbr(String[] dictionary) {
        dict = dictionary;
    }

    public boolean isUnique(String word) {
        int n = word.length();
        for (String s : dict) {
            if (word.equals(s)) {
                continue;
            }
            int m = s.length();
            if (m == n && s.charAt(0) == word.charAt(0) && s.charAt(m - 1) == word.charAt(n - 1)) {
                return false;
            }
        }
        return true;
    }
}
