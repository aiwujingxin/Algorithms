package leetCode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jingxinwu
 * @date 2021-12-18 8:22 PM
 */
public class LeetCode207 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return false;
        }
        int res = numCourses;
        int[] arr = new int[numCourses];
        for (int[] pair : prerequisites) {
            arr[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            for (int[] pair : prerequisites) {

                if (arr[pair[0]] == 0) {
                    continue;
                }

             //   [5,3]    3
                if (pair[1] == cur) {
                    arr[pair[0]]--;
                }

                if (arr[pair[0]] == 0) {
                    queue.add(pair[0]);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (arr[i] != 0) {

                return false;
            }

        }
        return true;
    }
}
