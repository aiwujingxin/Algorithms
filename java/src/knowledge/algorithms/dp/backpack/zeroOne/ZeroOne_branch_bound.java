package knowledge.algorithms.dp.backpack.zeroOne;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/26 23:19
 * @link <a href="https://www.bilibili.com/video/BV1gb411G7FH/?spm_id_from=333.788.recommend_more_video.-1&vd_source=88e5a3e60377510439e11f13b5878c25"></a>
 */
public class ZeroOne_branch_bound implements ZeroOnePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        Item[] arr = new Item[C.length];
        for (int i = 0; i < C.length; i++) {
            arr[i] = new Item(C[i], W[i]);
        }
        return solve(V, arr, C.length);
    }

    int solve(int W, Item[] arr, int n) {
        Arrays.sort(arr, new ItemComparator());
        Queue<Node> q = new LinkedList<>();
        Node u, v;
        u = new Node(-1, 0, 0, 0);
        q.add(u);

        int maxProfit = 0;
        while (!q.isEmpty()) {
            u = q.poll();

            if (u.level == -1) {
                v = new Node(0, 0, 0, 0);
            }
            if (u.level == n - 1) {
                continue;
            }

            v = new Node(u.level + 1, u.profit + arr[u.level + 1].value, 0, u.weight + arr[u.level + 1].weight);

            if (v.weight <= W && v.profit > maxProfit)
                maxProfit = v.profit;

            v.bound = bound(v, n, W, arr);
            if (v.bound > maxProfit)
                q.offer(v);

            v = new Node(u.level + 1, u.profit, 0, u.weight);
            v.bound = bound(v, n, W, arr);
            if (v.bound > maxProfit)
                q.offer(v);
        }

        return maxProfit;
    }

    // 上界函数
    int bound(Node u, int n, int W, Item[] arr) {
        if (u.weight >= W)
            return 0;

        int profitBound = u.profit;
        int j = u.level + 1;
        double totWeight = u.weight;

        while (j < n && totWeight + arr[j].weight <= W) {
            totWeight += arr[j].weight;
            profitBound += arr[j].value;
            j++;
        }

        if (j < n)
            profitBound += (int) ((W - totWeight) * arr[j].value / arr[j].weight);

        return profitBound;
    }

    static class Item {
        double weight;
        int value;

        public Item(double weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static class Node {
        int level;
        int profit;
        int bound;
        double weight;

        public Node(int level, int profit, int bound, double weight) {
            this.level = level;
            this.profit = profit;
            this.bound = bound;
            this.weight = weight;
        }
    }

    static class ItemComparator implements Comparator<Item> {
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        }
    }
}
