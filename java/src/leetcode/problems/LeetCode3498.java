package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/1/25 14:38
 */
public class LeetCode3498 {

    public int reverseDegree(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += (26 - (s.charAt(i) - 'a')) * (i + 1);
        }
        return ans;
    }
}
