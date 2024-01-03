package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 13:40
 */
public class LeetCode218_segtree {

    Map<Integer, Integer> mp = new HashMap<>();
    int[] tree;
    int n;

    List<List<Integer>> getSkyline(int[][] bs) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int[] b : bs) {
            set.add(b[0]);
            set.add(b[1]);
        }
        //排序去重+离散化处理；
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            mp.put(ans.get(i), i + 1);
        }
        build(n);
        for (int[] b : bs) {
            int l = mp.get(b[0]), r = mp.get(b[1]) - 1;
            update(1, 1, n, l, r, b[2]);
        }
        int pv = 0;
        for (int i = 0; i < n; i++) {
            int x = get(1, 1, n, i + 1);
            if (x != pv) { // 判断与上一个节点是否相同。
                res.add(Arrays.asList(ans.get(i), x));
                pv = x;
            }
        }
        return res;
    }


    public void build(int size) {
        tree = new int[size * 4];
        this.n = size;
    }

    private void update(int index, int left, int right, int L, int R, int V) {
        if (L <= left && right <= R) {
            tree[index] = Math.max(tree[index], V);
            return;
        }

        int mid = (right - left) / 2 + left;
        if (mid >= L) update(index * 2, left, mid, L, R, V);
        if (mid + 1 <= R) update(index * 2 + 1, mid + 1, right, L, R, V);
    }

    private int get(int index, int left, int right, int P) {
        if (left == right) return tree[index];
        int ans = 0;
        int mid = (right - left) / 2 + left;
        if (mid >= P) {
            ans = Math.max(tree[index], get(index * 2, left, mid, P));
        } else {
            ans = Math.max(tree[index], get(index * 2 + 1, mid + 1, right, P));
        }
        return ans;
    }

}
