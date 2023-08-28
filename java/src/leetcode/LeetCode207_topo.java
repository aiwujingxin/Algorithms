package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 23:09
 */
public class LeetCode207_topo {

    //20
    //[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        int[] nums = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            nums[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.isEmpty()) {
            return false;
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == course) {
                    nums[prerequisite[0]]--;
                    if (nums[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                    }
                }

            }
        }
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
