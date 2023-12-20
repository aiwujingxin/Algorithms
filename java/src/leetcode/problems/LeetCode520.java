package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 20:53
 */
public class LeetCode520 {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.isEmpty()) {
            return true;
        }
        int bigCount = 0;
        int smallCount = 0;
        int n = word.length();
        boolean isFirst = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                smallCount++;
            }
            if (c >= 'A' && c <= 'Z') {
                bigCount++;
            }
        }
        return bigCount == n || smallCount == n || (bigCount == 1 && isFirst);
    }
}
