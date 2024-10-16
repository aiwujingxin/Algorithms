package leetcode.problems;

import knowledge.datastructure.adv.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/11 20:26
 */
public class LeetCode839 {

    public int numSimilarGroups(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (check(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    public boolean check(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff <= 2;
    }
}
