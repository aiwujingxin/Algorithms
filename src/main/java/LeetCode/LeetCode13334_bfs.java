package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 10:41
 */
public class LeetCode13334_bfs {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //bfs
        //预处理
        int[][] arr = new int[n][n];
        for (int[] a : edges) {
            arr[a[0]][a[1]] = a[2];
            arr[a[1]][a[0]] = a[2];
        }
        int[] num = new int[n];
        Deque<int[]> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            q.addLast(new int[]{i, 0});
            map.put(i, 0);
            while (!q.isEmpty()) {
                int[] a = q.pollFirst();
                for (int j = 0; j < arr[a[0]].length; j++) {
                    if (arr[a[0]][j] != 0 && (!map.containsKey(j) || map.get(j) > arr[a[0]][j] + a[1])
                            && arr[a[0]][j] + a[1] <= distanceThreshold) {
                        q.addLast(new int[]{j, arr[a[0]][j] + a[1]});
                        map.put(j, arr[a[0]][j] + a[1]);
                    }
                }
            }
            num[i] = map.size() - 1;
            map.clear();
        }
        int min = Integer.MAX_VALUE;
        int id = 0;
        for (int i = 0; i < n; i++) {
            if (num[i] <= min) {
                id = i;
                min = num[i];
            }
        }
        return id;
    }
}
