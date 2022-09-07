package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jingxinwu
 * @date 2021-12-18 8:36 PM
 */
public class LeetCode210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return new int[0];
        }

        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int k = 0;
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                res[k++] = i;
            }
        }

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            for (int[] pair : prerequisites) {

                if (indegree[pair[0]] == 0) {
                    continue;
                }

                if (pair[1] == cur) {
                    indegree[pair[0]]--;
                }

                if (indegree[pair[0]] == 0) {
                    queue.add(pair[0]);
                    res[k++] = pair[0];
                }
            }
        }

        return k == numCourses ? res : new int[0];
    }
}
