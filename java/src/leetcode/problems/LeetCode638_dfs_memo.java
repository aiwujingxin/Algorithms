package leetcode.problems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/25 22:32
 */
public class LeetCode638_dfs_memo {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, new HashMap<>());
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, HashMap<List<Integer>, Integer> map) {
        if (map.containsKey(needs)) return map.get(needs);
        int minSum = 0;
        // 不使用special
        for (int i = 0; i < needs.size(); i++) {
            minSum += needs.get(i) * price.get(i);
        }

        // 每次使用一个special
        for (List<Integer> spe : special) {
            ArrayList<Integer> currNeeds = new ArrayList<>(needs);

            int i = 0;
            while (i < needs.size()) {
                int needDiff = currNeeds.get(i) - spe.get(i);
                if (needDiff < 0) break;
                currNeeds.set(i, needDiff);
                i++;
            }
            if (i == needs.size()) {
                minSum = Math.min(minSum, spe.get(i) + dfs(price, special, currNeeds, map));
            }
        }
        map.put(needs, minSum);
        return minSum;
    }
}
