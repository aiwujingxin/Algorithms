package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/30 11:20
 */
public class LeetCode2645 {

    public int addMinimum(String word) {
        int n = word.length(), cnt = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                cnt++;
            }
        }
        return cnt * 3 - n;
    }
}

