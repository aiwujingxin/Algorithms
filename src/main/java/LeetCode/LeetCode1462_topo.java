package LeetCode;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/21 21:51
 */
public class LeetCode1462_topo {
    //https://leetcode.com/problems/course-schedule-iv/discuss/746692/Java-or-TopologicalSort-and-BFS-or-O(N2)-time-or-46ms-or

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        // build graph
        //record pre
        List<Integer>[] pre = new List[n];
        //record all next course
        Set<Integer>[] next = new HashSet[n];
        //count next with prerequisites
        int[] nextCount = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = new ArrayList<>();
            next[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {
            pre[p[1]].add(p[0]);
            next[p[0]].add(p[1]);
            nextCount[p[0]]++;
        }
        //record removed course
        boolean[] used = new boolean[n];
        //find all course nextcount = 0
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (nextCount[i] == 0) {
                list.add(i);
                used[i] = true;
            }
        }
        while (!list.isEmpty()) {
            // get the no next course
            int remove = list.removeFirst();
            //find the pre courses
            for (int i : pre[remove]) {
                // make it nextcount--
                nextCount[i]--;
                //add all the next[remove]
                next[i].addAll(next[remove]);
                if (nextCount[i] == 0) {
                    //if not have other next, add to the have not next list
                    list.add(i);
                }
            }
        }
        //  check exist in the next list
        List<Boolean> res = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            res.add(next[q[0]].contains(q[1]));
        }
        return res;
    }
}
