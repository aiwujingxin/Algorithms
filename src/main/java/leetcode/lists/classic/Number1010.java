package leetcode.lists.classic;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/25 19:26
 */
public class Number1010 {
    // 并不能处理 x 不在树中的情况，x 不在树中，则会返回-1
    /*
    ["StreamRank", "track", "track","track","track","track","track","track","track","track", "getRankOfNumber","getRankOfNumber","getRankOfNumber","getRankOfNumber"]
[[], [5], [1], [4],[4],[5],[9],[7],[13],[3],[1],[3],[4],[9]]


    ["StreamRank", "track", "track","track","track","track","track","track", "getRankOfNumber"]
[[], [4], [3], [5],[3],[1],[5],[1],[9]]
    * */
    class StreamRank {

        public StreamRank() {
        }

        private static RankNode root = null;

        public void track(int x) {
            if (root == null) {
                root = new RankNode(x);
            } else {
                root.insert(x);
            }
        }

        public int getRankOfNumber(int x) {
            if (root == null) {
                return 0;
            }
            return root.getRank(x);
        }


    }

    static class RankNode {
        public int left_size = 0;
        public RankNode left;
        public RankNode right;
        public int data;

        public RankNode(int d) {
            data = d;
        }

        public void insert(int d) {
            if (d <= data) {
                if (left != null) {
                    left.insert(d);
                } else {
                    left = new RankNode(d);
                }
                left_size++;
            } else {
                if (right != null) {
                    right.insert(d);
                } else {
                    right = new RankNode(d);
                }
            }
        }

        public int getRank(int d) {
            if (d == data) {
                return left_size;
            } else if (d < data) {
                if (left == null) {
                    return -1;
                } else {
                    return left.getRank(d);
                }
            } else {
                int right_rank = right == null ? -1 : right.getRank(d);
                if (right_rank == -1) {
                    return -1;
                } else {
                    return left_size + 1 + right_rank;
                }
            }
        }
    }
}
