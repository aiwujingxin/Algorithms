package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/3 12:08
 */
public class LeetCode421 {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TrieNode trie = new TrieNode();
        for (int num : nums) {
            TrieNode root = trie;
            for (int bit = 31; bit >= 0; bit--) {
                int val = (num >> bit) & 1;
                if (root.children[val] == null) {
                    root.children[val] = new TrieNode();
                }
                root = root.children[val];
            }
        }

        int res = Integer.MIN_VALUE;

        for (int num : nums) {
            int t = 0;
            TrieNode root = trie;
            for (int bit = 31; bit >= 0; bit--) {

                int val = (num >> bit) & 1;

                if (val == 1) {
                    if (root.children[0] != null) {
                        root = root.children[0];
                        t += (1 << bit);
                    } else {
                        root = root.children[1];
                    }
                } else {
                    if (root.children[1] != null) {
                        root = root.children[1];
                        t += (1 << bit);
                    } else {
                        root = root.children[0];
                    }
                }
            }
            res = Math.max(res, t);
        }
        return res;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }
}
