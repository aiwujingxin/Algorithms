package leetcode.lists.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 15:11
 */
public class Offer13 {

    public static void main(String[] args) {
        System.out.println(new Offer13().cal(1, 2));
    }

    public int movingCount(int m, int n, int k) {
        int[][] dic = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        HashSet<String> set = new HashSet<>();
        set.add(0 + "," + 0);
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] ints : dic) {
                int nr = node[0] + ints[0];
                int nc = node[1] + ints[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || cal(nr, nc) > k || set.contains(nr + "," + nc)) {
                    continue;
                }
                set.add(nr + "," + nc);
                queue.add(new int[]{nr, nc});
            }
        }
        return set.size();
    }

    public int cal(int i, int j) {
        return i % 10 + i / 10 + j % 10 + j / 10;
    }
}
