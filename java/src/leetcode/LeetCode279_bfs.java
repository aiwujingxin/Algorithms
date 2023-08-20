package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/10 16:27
 */
public class LeetCode279_bfs {
    //https://leetcode.com/problems/perfect-squares/discuss/2321845/java-bfs-classic
    public int numSquares(int n) {
        //init
        int[] sq = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (square > n) {
                break;
            }
            sq[i] = square;
        }
        //start
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 1;
        queue.offer(n);
        // 层层剥离
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                Integer num = queue.poll();
                int k = (int) Math.sqrt(num);
                for (int i = k; i >= 1; i--) {
                    int res = num - sq[i];
                    if (res == 0) {
                        return count;
                    } else {
                        queue.offer(res);
                    }
                }
            }
            count++;
        }
        return count;
    }
}
