package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/24 18:17
 */
public class LeetCode370 {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for (int[] u : updates) {
            diff[u[0]] += u[2];
            if (u[1] + 1 < length) diff[u[1] + 1] -= u[2];
        }
        for (int i = 1; i < length; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}
