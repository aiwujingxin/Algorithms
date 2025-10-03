package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/17/25 11:41
 * @description 力可以传导
 */
public class LeetCode838_v2 {

    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();
        Queue<Integer> queue = new LinkedList<>();

        // 记录每个骨牌受到的力（正数表示向右的力，负数表示向左的力）
        int[] forces = new int[n];

        // 初始化：将所有初始倒下的骨牌加入队列
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'L') {
                queue.offer(i);
                forces[i] = -1; // 向左的力
            } else if (arr[i] == 'R') {
                queue.offer(i);
                forces[i] = 1;  // 向右的力
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] nextForces = forces.clone(); // 复制当前力状态

            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                int force = forces[pos];

                if (force == 0) continue; // 没有力可传递

                int nextPos = pos + force; // 力的传播方向

                // 检查边界和有效性
                if (nextPos < 0 || nextPos >= n) continue;

                if (arr[nextPos] == '.') { // 只影响竖立骨牌
                    if (nextForces[nextPos] == 0) {
                        // 第一次受到力
                        nextForces[nextPos] = force;
                        queue.offer(nextPos);
                    } else if (nextForces[nextPos] != force) {
                        // 受到相反方向的力，抵消
                        nextForces[nextPos] = 0;
                    }
                }
            }

            forces = nextForces;

            // 更新骨牌状态
            for (int i = 0; i < n; i++) {
                if (forces[i] == 1 && arr[i] == '.') {
                    arr[i] = 'R';
                } else if (forces[i] == -1 && arr[i] == '.') {
                    arr[i] = 'L';
                }
            }
        }
        return new String(arr);
    }
}
