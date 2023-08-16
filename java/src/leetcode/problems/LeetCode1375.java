package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-08-20 12:05 上午
 */
public class LeetCode1375 {

    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int curMax = 0;
        for (int i = 0; i < light.length; i++) {
            curMax = Math.max(curMax, light[i]);
            if (curMax == i + 1) {
                ans++;
            }
        }
        return ans;
    }
}
