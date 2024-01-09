package leetcode.problems;

import knowledge.advstructure.BinaryIndexedTree;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 22:10
 */
public class LeetCode1649 {

    public int createSortedArray(int[] instructions) {
        int mod = 1000000007;
        int cost = 0;
        BinaryIndexedTree bit = new BinaryIndexedTree(1000000);
        for (int i = 0; i < instructions.length; ++i) {
            int x = instructions[i];
            int smaller = bit.query(x - 1);
            int larger = i - bit.query(x);
            cost = (cost + Math.min(smaller, larger)) % mod;
            bit.update(x, 1);
        }
        return cost % mod;
    }
}
