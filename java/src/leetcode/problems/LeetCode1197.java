package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 14:31
 */
public class LeetCode1197 {

    // 1. 定义状态类，并重写 equals 和 hashCode
    static class State {
        long pos;
        long speed;

        State(long pos, long speed) {
            this.pos = pos;
            this.speed = speed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return pos == state.pos && speed == state.speed;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pos, speed);
        }
    }

    public int racecar(int target) {
        // 初始化队列和 visited 集合
        Queue<State> queue = new ArrayDeque<>();
        Set<State> visited = new HashSet<>();
        // 起点状态
        State startState = new State(0, 1);
        queue.offer(startState);
        visited.add(startState);
        int steps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                State current = queue.poll();
                // 检查是否到达终点
                if (current.pos == target) {
                    return steps;
                }
                // --- 生成邻居 ---
                // 指令 'A'
                State neighborA = new State(current.pos + current.speed, current.speed * 2);
                // 剪枝：位置不能太远，且不能重复访问
                if (Math.abs(neighborA.pos - target) < target && !visited.contains(neighborA)) {
                    queue.offer(neighborA);
                    visited.add(neighborA);
                }
                // 指令 'R'
                State neighborR = new State(current.pos, current.speed > 0 ? -1 : 1);
                if (!visited.contains(neighborR)) {
                    queue.offer(neighborR);
                    visited.add(neighborR);
                }
            }
            steps++;
        }
        return -1; // 理论上总能到达
    }
}
