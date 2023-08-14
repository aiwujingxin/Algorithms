package leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/10 16:55
 */
public class LeetCode322_bfs {


    //https://leetcode.com/problems/coin-change/discuss/2146147/Java-2-Approaches-%3A-DP-and-BFS
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> seenSet = new HashSet<>();
        queue.offer(amount);
        seenSet.add(amount);
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int currLevelSize = queue.size();
            for (int i = 0; i < currLevelSize; i++) {
                int currAmount = queue.poll();
                if (currAmount == 0) {
                    return currLevel;
                }
                for (int coin : coins) {
                    int remainingAmount = currAmount - coin;
                    if (remainingAmount >= 0 && !seenSet.contains(remainingAmount)) {
                        queue.offer(remainingAmount);
                        seenSet.add(remainingAmount);
                    }
                }
            }
            currLevel++;
        }
        return -1;
    }
}
