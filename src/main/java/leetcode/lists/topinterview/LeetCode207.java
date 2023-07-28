package leetcode.lists.topinterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 15:58
 */
public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        int[] arr = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            arr[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        //fix 注意add的是课程
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
                if (pair[1] == cur) {
                    arr[pair[0]]--;
                }
                if (arr[pair[0]] == 0) {
                    queue.add(pair[0]);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (arr[i] == 1) {
                return false;
            }

        }
        return true;
    }
}
