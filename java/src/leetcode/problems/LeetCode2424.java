package leetcode.problems;

import knowledge.advstructure.BinaryIndexedTree;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/5 12:57
 */
public class LeetCode2424 {


    class LUPrefix {

        BinaryIndexedTree bitTree;
        int n;

        public LUPrefix(int n) {
            this.n = n;
            this.bitTree = new BinaryIndexedTree(n + 1);
        }

        public void upload(int video) {
            bitTree.update(video, 1);
        }

        public int longest() {
            int left = 0;
            int right = n;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                int sum = bitTree.query(mid + 1) - bitTree.query(0);
                if (sum < mid) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;
        }
    }
}
