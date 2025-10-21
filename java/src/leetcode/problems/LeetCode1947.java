package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 17:41
 */
public class LeetCode1947 {

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int[][] score = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                score[i][j] = calculateScore(students[i], mentors[j]);
            }
        }
        int[] dp = new int[1 << m];
        for (int mask = 1; mask < (1 << m); mask++) {
            int i = Integer.bitCount(mask) - 1;  // 当前分配的是第i个学生
            for (int j = 0; j < m; j++) {
                if ((mask & (1 << j)) != 0) {    // 导师j被使用
                    int prevMask = mask ^ (1 << j);
                    dp[mask] = Math.max(dp[mask], dp[prevMask] + score[i][j]);
                }
            }
        }
        return dp[(1 << m) - 1];
    }

    private int calculateScore(int[] student, int[] mentor) {
        int score = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] == mentor[i]) {
                score++;
            }
        }
        return score;
    }
}
