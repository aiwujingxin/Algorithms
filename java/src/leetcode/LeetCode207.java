package leetcode;

import basic.datastructure.graph.detectcycle.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/28 16:49
 */
public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return !new DetectCycle_bfs().hasCycle(numCourses, prerequisites);
    }
}
