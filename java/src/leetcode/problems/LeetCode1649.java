package leetcode.problems;

import knowledge.datastructure.advanced.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 22:10
 */
public class LeetCode1649 {

    public int createSortedArray(int[] instructions) {
        int mod = 1000000007;
        int cost = 0;
        // 离散化
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : instructions) {
            tset.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer x : tset) {
            map.put(x, rank++);
        }
        BITree tree = new BITree(tset.size() + 1);
        for (int i = 0; i < instructions.length; ++i) {
            int x = map.get(instructions[i]);
            int smaller = tree.sum(x - 1);
            int larger = i - tree.sum(x);
            cost = (cost + Math.min(smaller, larger)) % mod;
            tree.add(x, 1);
        }
        return cost % mod;
    }
}
