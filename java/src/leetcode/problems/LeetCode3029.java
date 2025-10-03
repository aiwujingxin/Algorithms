package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 16:49
 */
public class LeetCode3029 {

    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        for (int t = 1; t * k <= n; t++) {
            if (word.startsWith(word.substring(t * k))) {
                return t;
            }
        }
        return (n + k - 1) / k;
    }
}
