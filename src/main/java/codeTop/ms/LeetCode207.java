package codeTop.ms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jingxinwu
 * @date 2022-02-16 4:02 PM
 */
public class LeetCode207 {

    public static void main(String[] args) {
        System.out.println(new LeetCode207().canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
    }

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
