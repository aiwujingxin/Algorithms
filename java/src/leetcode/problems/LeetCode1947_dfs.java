package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 10/15/25 11:29
 */
public class LeetCode1947_dfs {

    Integer[][] memo;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int[][] score = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                score[i][j] = calculateScore(students[i], mentors[j]);
            }
        }
        memo = new Integer[m][1 << m];
        return backtrack(0, 0, score, m);
    }

    private int backtrack(int i, int mask, int[][] score, int m) {
        if (i == m) return 0;
        if (memo[i][mask] != null) return memo[i][mask];
        int maxScore = 0;
        // 尝试为当前学生分配每一个可用的导师
        for (int mentorIdx = 0; mentorIdx < m; mentorIdx++) {
            if ((mask & (1 << mentorIdx)) == 0) {  // 检查导师是否已被使用
                int currentScore = score[i][mentorIdx];
                int remainingScore = backtrack(i + 1, mask | (1 << mentorIdx), score, m);
                maxScore = Math.max(maxScore, currentScore + remainingScore);
            }
        }
        memo[i][mask] = maxScore;
        return maxScore;
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
