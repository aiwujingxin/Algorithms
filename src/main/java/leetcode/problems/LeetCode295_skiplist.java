package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/27 14:13
 */
public class LeetCode295_skiplist {
    class MedianFinder {

        class SkiplistNode {
            int val;
            SkiplistNode[] next;
            SkiplistNode pre;

            SkiplistNode(int v, int lv) {
                val = v;
                next = new SkiplistNode[lv];
            }
        }

        class Skiplist {
            private static final int MAX_LEVEL = 32;
            //            private static final double FACTOR = 0.25;
            private int level;
            private final SkiplistNode head;

            Skiplist() {
                head = new SkiplistNode(-1, MAX_LEVEL);
            }

            void add(int num) {
                int lv = randomLevel();
                SkiplistNode nnode = new SkiplistNode(num, lv);
                SkiplistNode cur = head;
                for (int i = level - 1; i >= 0; i--) {
                    while (cur.next[i] != null && cur.next[i].val < num) {
                        cur = cur.next[i];
                    }
                    if (i < lv) {
                        nnode.next[i] = cur.next[i];
                        cur.next[i] = nnode;
                    }
                }
                nnode.pre = cur;
                if (nnode.next[0] != null) {
                    nnode.next[0].pre = nnode;
                }
                if (lv > level) {
                    for (int i = level; i < lv; i++) {
                        head.next[i] = nnode;
                    }
                    level = lv;
                }
            }

            SkiplistNode getHead() {
                return head;
            }

            private int randomLevel() {
                int lv = 1;
                while (lv < MAX_LEVEL && Math.random() < 0.25) {
                    lv++;
                }
                return lv;
            }
        }

        private final Skiplist skiplist;
        private int n;
        private SkiplistNode left;
        private SkiplistNode right;

        public MedianFinder() {
            skiplist = new Skiplist();
            left = right = skiplist.getHead();
        }

        public void addNum(int num) {
            skiplist.add(num);
            if (n == 0) {
                left = left.next[0];
                right = right.next[0];
            } else if ((n & 1) == 1) {
                if (num <= left.val) {
                    left = left.pre;
                } else {
                    right = right.next[0];
                }
            } else {
                if (num > left.val && num <= right.val) {
                    left = left.next[0];
                    right = right.pre;
                } else if (num <= left.val) {
                    right = right.pre;
                } else {
                    left = left.next[0];
                }
            }
            n++;
        }

        public double findMedian() {
            return (left.val + right.val) / 2.0;
        }
    }
}
