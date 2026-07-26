package knowledge.datastructure.adv.BIT;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 二维树状数组：单点增加，二维前缀和与矩形和查询，时间复杂度 O(log n log m)
 */
public class BITree2D {

    private final int[][] tree;

    public BITree2D(int rows, int cols) {
        tree = new int[rows + 1][cols + 1];
    }

    public void add(int x, int y, int delta) {
        for (int i = x; i < tree.length; i += i & -i) {
            for (int j = y; j < tree[0].length; j += j & -j) {
                tree[i][j] += delta;
            }
        }
    }

    public int sum(int x, int y) {
        int ans = 0;
        for (int i = x; i > 0; i -= i & -i) {
            for (int j = y; j > 0; j -= j & -j) {
                ans += tree[i][j];
            }
        }
        return ans;
    }

    public int rangeSum(int r1, int c1, int r2, int c2) {
        return sum(r2, c2) - sum(r1 - 1, c2) - sum(r2, c1 - 1) + sum(r1 - 1, c1 - 1);
    }
}
