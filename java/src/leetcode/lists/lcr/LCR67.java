package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 22:37
 */
public class LCR67 {

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int bit = 31; bit >= 0; bit--) {
                int curr = (num >> bit) & 1;
                if (node.children[curr] == null) {
                    node.children[curr] = new TrieNode();
                }
                node = node.children[curr];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            TrieNode node = root;
            int sum = 0;
            for (int bit = 31; bit >= 0; bit--) {
                int curr = (num >> bit) & 1;
                if (curr == 0) {
                    if (node.children[1] != null) {
                        sum += (1 << bit);
                        node = node.children[1];
                    } else {
                        node = node.children[0];
                    }
                } else {
                    if (node.children[0] != null) {
                        sum += (1 << bit);
                        node = node.children[0];
                    } else {
                        node = node.children[1];
                    }
                }

            }
            res = Math.max(res, sum);
        }

        return res;
    }


    static class TrieNode {
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[2];
        }
    }
}
