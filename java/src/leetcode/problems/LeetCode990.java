package leetcode.problems;

import knowledge.datastructure.adv.UnionFind;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 18:45
 */
public class LeetCode990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                char x = e.charAt(0);
                char y = e.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!') {
                char x = e.charAt(0);
                char y = e.charAt(3);
                if (uf.isConnected(x - 'a', y - 'a'))
                    return false;
            }
        }
        return true;
    }
}
