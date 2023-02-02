package leetcode.plan.graph.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 21:37
 */
public class LeetCode797 {

    public static void main(String[] args) {
        System.out.println(new LeetCode797().
                allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        if (graph == null || graph.length == 0) {
            return new ArrayList<>();
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<List<Integer>> path = new LinkedList<>();
        queue.add(0);


        List<List<Integer>> res = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(0);
        path.add(t);
        while (!queue.isEmpty()) {

            int node = queue.poll();
            List<Integer> p = path.poll();

            int[] nexts = graph[node];

            for (int next : nexts) {

                List<Integer> temp = new ArrayList<>(p);
                temp.add(next);


                if (next + 1 == graph.length) {
                    res.add(temp);
                } else {
                    path.add(temp);
                    queue.add(next);
                }
            }
        }
        return res;
    }
}
