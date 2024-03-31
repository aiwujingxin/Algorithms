package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/30 14:59
 */
public class LeetCode1503 {

    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;
        for (int ant : left) {
            lastMoment = Math.max(lastMoment, ant);
        }
        for (int ant : right) {
            lastMoment = Math.max(lastMoment, n - ant);
        }
        return lastMoment;
    }
}
