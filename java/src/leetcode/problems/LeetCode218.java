package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 17:56
 */
public class LeetCode218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        // 将每个建筑拆成两个事件：起点和终点，起点用正高，终点用负高区分
        for (int[] b : buildings) {
            events.add(new int[]{b[0], b[2]});   // 起点，高度为正
            events.add(new int[]{b[1], -b[2]});  // 终点，高度为负
        }
        // 按x坐标排序；同一x坐标，起点优先高的在前，终点优先低的在前
        events.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);  // 初始化高度0，代表地面
        int prevMax = 0;

        for (int[] event : events) {
            int x = event[0];
            int h = event[1];
            if (h > 0) {
                // 遇到建筑起点，加入高度
                pq.add(h);
            } else {
                // 遇到建筑终点，移除对应高度
                pq.remove(-h);
            }

            int currMax = pq.peek();  // 当前最高高度
            if (currMax != prevMax) {
                // 高度发生变化，记录关键点
                result.add(Arrays.asList(x, currMax));
                prevMax = currMax;
            }
        }
        return result;
    }
}
