package leetcode.problems;

import knowledge.advstructure.BITree;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 22:10
 */
public class LeetCode1649 {

    public int createSortedArray(int[] instructions) {
        int mod = 1000000007;
        int cost = 0;
        BITree bit = new BITree(1000000);
        for (int i = 0; i < instructions.length; ++i) {
            int x = instructions[i];
            int smaller = bit.sum(x - 1);
            int larger = i - bit.sum(x);
            cost = (cost + Math.min(smaller, larger)) % mod;
            bit.add(x, 1);
        }
        return cost % mod;
    }
}
