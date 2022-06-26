package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/20 22:09
 */
public class LeetCode1306 {

    public boolean canReach(int[] arr, int start) {

        if (arr == null || arr.length == 0) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }
        if (arr.length == 1) {
            return arr[0] == 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            List<Integer> list = get(cur, arr);
            for (Integer next : list) {
                if (visited[next]) {
                    continue;
                }
                if (arr[next] == 0) {
                    return true;
                }
                queue.add(next);
                visited[next] = true;
            }
        }
        return false;
    }

    private List<Integer> get(Integer cur, int[] arr) {
        List<Integer> list = new ArrayList<>();
        int step = arr[cur];
        if (cur + step < arr.length && cur + step >= 0) {
            list.add(cur + step);
        }
        if (cur - step < arr.length && cur - step >= 0) {
            list.add(cur - step);
        }
        return list;
    }
}


