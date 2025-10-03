package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 17:41
 */
public class LeetCode1947 {

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        // 预计算兼容性分数
        int[][] score = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                score[i][j] = calculateScore(students[i], mentors[j]);
            }
        }
        // DP数组：dp[mask] 表示当前导师分配状态为mask时的最大兼容性评分和
        int[] dp = new int[1 << m];
        // 遍历所有可能的导师分配状态
        for (int mask = 0; mask < (1 << m); mask++) {
            // 计算当前已经分配了多少个学生（即mask中1的个数）
            int studentCount = Integer.bitCount(mask);
            // 为第studentCount个学生分配导师
            for (int j = 0; j < m; j++) {
                // 如果导师j还没有被分配
                if ((mask & (1 << j)) == 0) {
                    int newMask = mask | (1 << j);
                    dp[newMask] = Math.max(dp[newMask], dp[mask] + score[studentCount][j]);
                }
            }
        }
        return dp[(1 << m) - 1];
    }

    // 计算学生和导师答案的兼容性分数
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
