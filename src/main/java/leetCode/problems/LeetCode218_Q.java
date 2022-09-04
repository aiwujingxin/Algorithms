package leetCode.problems;


import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/8/1 22:23
 */
public class LeetCode218_Q {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 如果将所有的建筑的边界作为一条线，那么所有的答案都在这些线上
        // 考虑任意一条线，那么这条线和所有相交的建筑（这里排除掉刚好和建筑右边界相交），取一个最高的
        // 高度，然后判断这个高度是否和ans末尾最后一个元素的高度相等，不相等就加入进去
        // 在这里为了快速得到最高的高度，使用一个堆来进行记录

        // 得到所有由建筑边界构成的边界线，并升序
        int[] boundaries = new int[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            boundaries[2 * i] = buildings[i][0];
            boundaries[2 * i + 1] = buildings[i][1];
        }
        Arrays.sort(boundaries);

        // 创建一个堆，维护一个边界-高度值对
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        List<List<Integer>> ans = new ArrayList<>(); // 返回答案
        int index = 0; // 指向buildings
        for (int boundary : boundaries) {
            // 对于一个建筑，如果其左边界在当前判断的边界线左边或重叠，那么向堆加入右边界-高度值对
            while (index < buildings.length && buildings[index][0] <= boundary) {
                pq.offer(new int[]{buildings[index][1], buildings[index][2]});
                index++;
            }

            // 对于那些加入了堆中的建筑，从堆的顶部移出建筑右边界在边界线左边或重叠的边界-高度值对
            while (!pq.isEmpty() && pq.peek()[0] <= boundary) {
                pq.poll();
            }

            // 经过上面的两步操作之后，当前边界线穿过的建筑（不含右边界）全都在堆中，并且堆的顶端是所有穿过的建筑中，高度最高的，也就是天际线高度
            // 如果此时的堆为空，证明边界线没有穿过任何建筑，来到了建筑的分割位置，天际线为0
            int maxHeight = pq.isEmpty() ? 0 : pq.peek()[1];

            // 按照这种算法，每一条边界线都会产生一个天际线高度，如果这个高度和ans末尾元素的高度一致，那么就说明两条边界线穿过了同一个建筑，并且相邻，那么按照规则只取最左端
            if (ans.size() == 0 || maxHeight != ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(boundary, maxHeight));
            }
        }

        return ans;
    }
}
