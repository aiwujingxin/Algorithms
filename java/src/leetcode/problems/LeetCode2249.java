package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/4 14:57
 */
public class LeetCode2249 {

    public int countLatticePoints(int[][] circles) {
        int cnt = 0;
        for (int x = -200; x <= 200; x++) {
            for (int y = -200; y <= 200; y++) {
                for (int[] c : circles) {
                    if ((x - c[0]) * (x - c[0]) + (y - c[1]) * (y - c[1]) <= c[2] * c[2]) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}
