package leetcode.problems;

import knowledge.datastructure.advanced.BITree;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/5 12:57
 */
public class LeetCode2424 {


    class LUPrefix {

        BITree bitTree;
        int n;

        public LUPrefix(int n) {
            this.n = n;
            this.bitTree = new BITree(n + 1);
        }

        public void upload(int video) {
            bitTree.add(video, 1);
        }

        public int longest() {
            int l = 0;
            int r = n;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                int sum = bitTree.sum(mid + 1) - bitTree.sum(0);
                if (sum < mid) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            return l;
        }
    }
}
