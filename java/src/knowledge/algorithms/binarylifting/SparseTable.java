package knowledge.algorithms.binarylifting;

/**
 * @author wujingxinit@outlook.com
 * @date 10/2/24 16:29
 * @description ST 表
 * ST 表基于 倍增 思想，可以做到 O(nlogn) 预处理，O(1) 回答每个询问。但是不支持修改操作。
 */
public class SparseTable {

    int[][] st;
    int n;

    public SparseTable(int[] arr) {
        n = arr.length;
        int k = (int) (Math.log(n) / Math.log(2));
        st = new int[n][k + 1];

        // 初始化 st 表，长度为 n 的区间的最值就是 arr 本身
        for (int i = 0; i < n; i++) {
            st[i][0] = arr[i];
        }

        // 动态规划填充 st 表
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // 查询区间 [l, r] 的最小值
    public int query(int l, int r) {
        int j = (int) (Math.log(r - l + 1) / Math.log(2));
        return Math.min(st[l][j], st[r - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        SparseTable st = new SparseTable(new int[]{9, 4, 6, 4, 3, 2, 5, 6, 6, 4, 3});
        int[][] query = new int[][]{{1, 3}, {3, 8}, {3, 9}};
        for (int[] q : query) {
            int l = q[0];
            int r = q[1];
            int minValue = st.query(l, r);
            System.out.println("区间 [" + l + ", " + r + "] 的最小值为：" + minValue);
        }
    }
}
