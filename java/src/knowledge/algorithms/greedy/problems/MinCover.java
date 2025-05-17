package knowledge.algorithms.greedy.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 4/16/25 00:24
 * @description 区间覆盖问题
 * 描述：选择最少数量的线段，使得它们的并集完全覆盖 [0, n]。如果无法覆盖，返回 -1。
 * 核心思想：贪心选择能覆盖当前起点且延伸最远的线段。
 */

public class MinCover {

    public int minCover(int[][] lines, int n) {
        Arrays.sort(lines, (o1, o2) -> o1[0] - o2[0]); // 按左端点升序排序
        int count = 0;
        int currentStart = 0;
        int index = 0;
        while (currentStart < n) {
            int maxEnd = currentStart;
            // 找到能覆盖 currentStart 且右端点最大的线段
            while (index < lines.length && lines[index][0] <= currentStart) {
                maxEnd = Math.max(maxEnd, lines[index][1]);
                index++;
            }
            if (maxEnd == currentStart) {
                return -1; // 无法继续扩展，无法覆盖
            }
            currentStart = maxEnd;
            count++;
        }
        return count;
    }
}