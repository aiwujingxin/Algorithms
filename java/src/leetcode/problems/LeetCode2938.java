package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/15 14:36
 */
public class LeetCode2938 {

    public long minimumSteps(String s) {
        long ans = 0;
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt1++;
            } else {
                ans += cnt1;
            }
        }
        return ans;
    }
}
