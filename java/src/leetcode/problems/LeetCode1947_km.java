package leetcode.problems;

import knowledge.datastructure.graph.bipartite.impl.KM;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 17:44
 */
public class LeetCode1947_km {

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length; // 学生和导师的数量
        // 步骤 1: 构建权重矩阵
        // graph[i][j] 代表学生 i 和导师 j 的兼容性评分
        int[][] graph = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = calculateScore(students[i], mentors[j]);
            }
        }
        // 步骤 2: 传入我们构建好的权重矩阵 它会返回最大权匹配的和
        return new KM(graph).solve();
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
