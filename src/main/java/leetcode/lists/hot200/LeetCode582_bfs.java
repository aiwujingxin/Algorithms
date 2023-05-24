package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/19 17:28
 */
public class LeetCode582_bfs {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int max = 0;
        for (int val : pid) {
            if (val > max) {
                max = val;
            }
        }
        List<Integer>[] children = new List[max + 1];
        for (int i = 0; i <= max; i++) {
            children[i] = new ArrayList<>();
        }
        int n = pid.size();
        for (int i = 0; i < n; i++) {
            children[ppid.get(i)].add(pid.get(i));
        }
        boolean[] visited = new boolean[max + 1];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(kill);
        while (!q.isEmpty()) {
            int poll = q.poll();
            visited[poll] = true;
            for (int c : children[poll]) {
                q.add(c);
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int id : pid) {
            if (visited[id]) {
                ret.add(id);
            }
        }
        return ret;
    }
}
