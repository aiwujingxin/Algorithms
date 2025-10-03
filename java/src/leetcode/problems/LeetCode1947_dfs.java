package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 17:46
 */
public class LeetCode1947_dfs {

    private int maxScore = 0;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        boolean[] used = new boolean[m];
        dfs(students, mentors, used, 0, 0);
        return maxScore;
    }

    private void dfs(int[][] students, int[][] mentors, boolean[] used, int studentIdx, int currentScore) {
        if (studentIdx == students.length) {
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        for (int i = 0; i < mentors.length; i++) {
            if (!used[i]) {
                used[i] = true;
                int score = calculateScore(students[studentIdx], mentors[i]);
                dfs(students, mentors, used, studentIdx + 1, currentScore + score);
                used[i] = false;
            }
        }
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
