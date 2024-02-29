package knowledge.dp.backpack.dependence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/29 10:45
 */
public class DependPack_dp implements DependPack {

    @Override
    public int backPack(int[][] items, int m, int n) {
        Item[] master = new Item[n + 1];
        List<Item>[] servant = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            master[i] = new Item(0, 0);
            servant[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int v = items[i - 1][0];
            int p = items[i - 1][1];
            int q = items[i - 1][2];
            p *= v;
            if (q == 0) {
                master[i] = new Item(v, p);
            } else {
                servant[q].add(new Item(v, p));
            }
        }

        int[] f = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int u = m; u >= 0; u--) {
                for (int j = 0; j < (1 << servant[i].size()); j++) {
                    int v = master[i].v;
                    int w = master[i].w;
                    for (int k = 0; k < servant[i].size(); k++) {
                        if ((j >> k & 1) == 1) {
                            v += servant[i].get(k).v;
                            w += servant[i].get(k).w;
                        }
                    }
                    if (u >= v) {
                        f[u] = Math.max(f[u], f[u - v] + w);
                    }
                }
            }
        }
        return f[m];
    }

    static class Item {
        int v;
        int w;

        public Item(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
