package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/23 13:12
 */
public class LeetCode2511 {

    public int captureForts(int[] forts) {
        int n = forts.length;
        int ans = 0, pre = -1;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre]) {
                    ans = Math.max(ans, i - pre - 1);
                }
                pre = i;
            }
        }
        return ans;
    }
}
