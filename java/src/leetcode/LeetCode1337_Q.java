package leetcode;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 17:48
 */
public class LeetCode1337_Q {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        //战力大根堆,堆顶元素为战力最大的数对。
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (mat[i][mid] >= 1) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int cur = mat[i][r] >= 1 ? r + 1 : r;
            //如果当前战力值比堆顶的元素要大：直接丢弃当前战力值（不可能属于在第 k 小的集合中）；
            //如果当前战力值比堆顶的元素要小：将堆顶元素弹出，将当前行放入堆中。
            if (q.size() == k && q.peek()[0] > cur) {
                q.poll();
            }
            if (q.size() < k) {
                q.add(new int[]{cur, i});
            }

        }
        int[] ans = new int[k];
        int idx = k - 1;
        while (!q.isEmpty()) {
            ans[idx--] = q.poll()[1];
        }
        return ans;
    }
}
