package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jingxinwu
 * @date 2022-02-17 7:37 PM
 */
public class LeetCode210 {


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> list = new ArrayList<>();

        int[] arr = new int[numCourses];

        for (int[] ints : prerequisites) {
            arr[ints[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                queue.add(i);
                list.add(i);
            }

        }
        while (!queue.isEmpty()) {

            int cur = queue.poll();

            //fix
            for (int[] prerequisite : prerequisites) {

                if (arr[prerequisite[0]] == 0) {
                    continue;
                }
                if (prerequisite[1] == cur) {
                    arr[prerequisite[0]]--;
                }
                if (arr[prerequisite[0]] == 0) {
                    queue.add(prerequisite[0]);
                    list.add(prerequisite[0]);
                }
            }
        }

        //fix
        if (list.size() != numCourses) {
            return new int[]{};
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}
