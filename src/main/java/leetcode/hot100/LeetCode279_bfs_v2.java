package leetcode.hot100;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/10 16:37
 */
public class LeetCode279_bfs_v2 {

    //https://leetcode.com/problems/perfect-squares/discuss/2235693/simple-java-solution

    public int numSquares(int n) {
        return this.sol(n);
    }

    public int sol(int n) {
        Queue<int[]> que = new ArrayDeque<>(2);
        Map<Integer, Integer> map = new HashMap<>();
        int[] x = new int[]{0, 0};
        que.add(x);
        int max = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            int sum = que.peek()[0];
            int parent = que.remove()[1];
            int count = 1;
            if (!map.containsKey(sum)) {
                while (sum + count * count <= n) {
                    int[] xc = {sum + count * count, parent + 1};
                    que.add(xc);
                    if (sum + count * count == n) {
                        max = Math.min(max, xc[1]);
                    }
                    count = count + 1;
                }
                map.put(sum, 1);
            }
        }
        return max;
    }
}
