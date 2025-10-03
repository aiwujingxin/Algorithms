package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/7 15:49
 */
public class LeetCode789 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = {0, 0};
        int distance = cal(source, target);
        for (int[] ghost : ghosts) {
            if (cal(ghost, target) <= distance) {
                return false;
            }
        }
        return true;
    }

    public int cal(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
