package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 10/21/25 16:22
 */
public class LeetCode2944 {

    class Solution {
        Map<Integer, Integer> memo = new HashMap<>();
        int[] prices;

        public int minimumCoins(int[] prices) {
            this.prices = prices;
            return dfs(0);
        }

        public int dfs(int index) {
            if (2 * index + 2 >= prices.length) return prices[index];
            if (memo.containsKey(index)) return memo.get(index);
            int minValue = Integer.MAX_VALUE;
            for (int i = index + 1; i <= 2 * index + 2; i++) {
                minValue = Math.min(minValue, dfs(i));
            }
            memo.put(index, prices[index] + minValue);
            return memo.get(index);
        }
    }

    class Solution_dp {
        public int minimumCoins(int[] prices) {
            int n = prices.length;
            int[] dp = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                int rightMost = Math.min(n - 1, 2 * i + 2);
                if (2 * i + 2 >= n) {
                    dp[i] = prices[i];
                } else {
                    int minNext = Integer.MAX_VALUE;
                    for (int j = i + 1; j <= rightMost; j++) {
                        if (dp[j] < minNext) minNext = dp[j];
                    }
                    dp[i] = prices[i] + minNext;
                }
            }
            return dp[0];
        }
    }

    class Solution_Seg_opt {

        public int minimumCoins(int[] prices) {
            int n = prices.length;
            int[] dp = new int[n];
            SegTree seg = new SegTree(n);
            Arrays.fill(dp, Integer.MAX_VALUE);
            seg.build(1, 0, n - 1, dp);
            for (int i = n - 1; i >= 0; i--) {
                int r = Math.min(n - 1, 2 * i + 2);
                if (2 * i + 2 >= n) {
                    dp[i] = prices[i];
                } else {
                    int minNext = seg.query(1, 0, n - 1, i + 1, r);
                    dp[i] = prices[i] + minNext;
                }
                seg.update(1, 0, n - 1, i, dp[i]);
            }
            return dp[0];
        }

        static class SegTree {
            int n;
            int[] tree;

            SegTree(int n) {
                this.n = n;
                tree = new int[4 * n];
                Arrays.fill(tree, Integer.MAX_VALUE);
            }

            void build(int idx, int l, int r, int[] base) {
                if (l == r) {
                    tree[idx] = base[l];
                    return;
                }
                int mid = (l + r) >>> 1;
                build(idx << 1, l, mid, base);
                build(idx << 1 | 1, mid + 1, r, base);
                tree[idx] = Math.min(tree[idx << 1], tree[idx << 1 | 1]);
            }

            void update(int idx, int l, int r, int pos, int val) {
                if (l == r) {
                    tree[idx] = val;
                    return;
                }
                int mid = (l + r) >>> 1;
                if (pos <= mid) update(idx << 1, l, mid, pos, val);
                else update(idx << 1 | 1, mid + 1, r, pos, val);
                tree[idx] = Math.min(tree[idx << 1], tree[idx << 1 | 1]);
            }

            int query(int idx, int l, int r, int ql, int qr) {
                if (ql > r || qr < l) return Integer.MAX_VALUE;
                if (ql <= l && r <= qr) return tree[idx];
                int mid = (l + r) >>> 1;
                return Math.min(query(idx << 1, l, mid, ql, qr), query(idx << 1 | 1, mid + 1, r, ql, qr));
            }
        }
    }

    class Solution_dq_opt {

        public int minimumCoins(int[] prices) {
            int n = prices.length;
            int[] dp = new int[n + 1];
            Deque<Integer> dq = new ArrayDeque<>();
            dq.addLast(n);
            for (int i = n - 1; i >= 0; i--) {
                // 删
                while (dq.getFirst() > 2 * i + 2) dq.pollFirst();
                // 结果
                dp[i] = prices[i] + dp[dq.getFirst()];
                // 加
                while (dp[dq.getLast()] >= dp[i]) dq.pollLast();
                dq.addLast(i);
            }
            return dp[0];
        }
    }

    class Solution_WA {

        public int minimumCoins(int[] prices) {
            int n = prices.length;
            int cnt = prices[0];
            for (int i = 1; i + i < n; i++) {
                int last = i - 1;
                int min = Integer.MAX_VALUE;
                int t = last;
                for (int j = last + 1; j <= last + last + 1 && j < n; j++) {
                    if (prices[j] <= min) {
                        min = prices[j];
                        t = j;
                    }
                }
                int next = 2 * last + 2;
                if (prices[t] < prices[next]) {
                    cnt += prices[t];
                    i = t + t;
                } else {
                    cnt += prices[next];
                    i = next;
                }
            }
            return cnt;
        }
    }
}
