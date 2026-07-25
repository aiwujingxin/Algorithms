package knowledge.datastructure.adv.impl;

/**
 * 二维树状数组 (2D Binary Indexed Tree)。
 * 支持二维平面上「单点更新」和「矩形前缀和查询」，均为 O(log^2 N)。
 * 矩形 [(r1,c1),(r2,c2)] 的和用二维前缀和容斥：S(r2,c2)-S(r1-1,c2)-S(r2,c1-1)+S(r1-1,c1-1)。
 */
public class BITree2D {
    private final int[][] tree;
    private final int rows, cols;

    public BITree2D(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.tree = new int[rows + 1][cols + 1];
    }

    /** 单点增加：在 (x,y) 处增加 val（1-indexed）。 */
    public void add(int x, int y, int val) {
        for (int i = x; i <= rows; i += (i & -i)) {
            for (int j = y; j <= cols; j += (j & -j)) {
                tree[i][j] += val;
            }
        }
    }

    /** 前缀和：矩形 [(1,1),(x,y)] 的和。 */
    public int sum(int x, int y) {
        int res = 0;
        for (int i = x; i > 0; i -= (i & -i)) {
            for (int j = y; j > 0; j -= (j & -j)) {
                res += tree[i][j];
            }
        }
        return res;
    }

    /** 矩形 [(r1,c1),(r2,c2)] 的区间和。 */
    public int query(int r1, int c1, int r2, int c2) {
        return sum(r2, c2) - sum(r1 - 1, c2) - sum(r2, c1 - 1) + sum(r1 - 1, c1 - 1);
    }
}
