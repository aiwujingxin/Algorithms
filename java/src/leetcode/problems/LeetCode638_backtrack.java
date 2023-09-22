package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/25 13:56
 */
public class LeetCode638_backtrack {
    List<Integer> price;
    List<Integer> needs;
    List<List<Integer>> special;

    int res = Integer.MAX_VALUE;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = special.get(0).size();
        for (int i = 0; i < price.size(); i++) {
            int[] p = new int[n];
            p[i] = 1;
            p[p.length - 1] = price.get(i);
            List<Integer> pl = new ArrayList<>();
            for (int k : p) {
                pl.add(k);
            }
            special.add(pl);
        }
        this.price = price;
        this.special = special;
        this.needs = needs;

        dfs(0, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int index, int sum) {
        if (eq()) {
            res = Math.min(res, sum);
            return;
        }
        if (sum >= res) {
            return;
        }
        for (int i = index; i < special.size(); i++) {
            if (!check(special.get(i), needs)) {
                continue;
            }
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) - special.get(i).get(j));
            }
            dfs(i, sum + special.get(i).get(special.get(i).size() - 1));
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) + special.get(i).get(j));
            }
        }
    }

    private boolean eq() {
        for (int cur : needs) {
            if (cur != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean check(List<Integer> give, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < give.get(i)) {
                return false;
            }
        }
        return true;
    }
}
