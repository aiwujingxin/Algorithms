package knowledge.algorithms.binarylifting;

/**
 * @author wujingxinit@outlook.com
 * @date 10/2/24 16:29
 * @description ST 表 (Sparse Table)
 * ST 表基于倍增思想，O(nlogn) 预处理、O(1) 回答区间可重复贡献查询（最值、GCD、按位与/或），不支持修改。
 * <本质>
 * st[i][j] 表示从 i 开始、长度 2^j 的区间的合并结果，由两个长度 2^(j-1) 的子区间合并得到。
 * 查询 [l,r] 取最大的 2^j ≤ 区间长，用 [l,l+2^j-1] 与 [r-2^j+1,r] 两段覆盖（幂等性允许重叠）。
 * @see BinaryLiftingLCA 同为倍增思想的树上祖先结构
 */
public class SparseTable {

    private final int[][] stMin;
    private final int[][] stMax;
    private final int[][] stGcd;

    public SparseTable(int[] arr) {
        int n = arr.length;
        int k = (int) (Math.log(n) / Math.log(2));
        stMin = new int[n][k + 1];
        stMax = new int[n][k + 1];
        stGcd = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            stMin[i][0] = stMax[i][0] = stGcd[i][0] = arr[i];
        }
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                int right = i + (1 << (j - 1));
                stMin[i][j] = Math.min(stMin[i][j - 1], stMin[right][j - 1]);
                stMax[i][j] = Math.max(stMax[i][j - 1], stMax[right][j - 1]);
                stGcd[i][j] = gcd(stGcd[i][j - 1], stGcd[right][j - 1]);
            }
        }
    }

    /**
     * 区间 [l, r] 的最小值。
     */
    public int queryMin(int l, int r) {
        int j = log2(r - l + 1);
        return Math.min(stMin[l][j], stMin[r - (1 << j) + 1][j]);
    }

    /**
     * 区间 [l, r] 的最大值。
     */
    public int queryMax(int l, int r) {
        int j = log2(r - l + 1);
        return Math.max(stMax[l][j], stMax[r - (1 << j) + 1][j]);
    }

    /**
     * 区间 [l, r] 的最大公约数。
     */
    public int queryGcd(int l, int r) {
        int j = log2(r - l + 1);
        return gcd(stGcd[l][j], stGcd[r - (1 << j) + 1][j]);
    }

    private static int log2(int x) {
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        SparseTable st = new SparseTable(new int[]{9, 4, 6, 4, 3, 2, 5, 6, 6, 4, 3});
        System.out.println("min[3,8]=" + st.queryMin(3, 8));
        System.out.println("max[3,8]=" + st.queryMax(3, 8));
        System.out.println("gcd[0,3]=" + st.queryGcd(0, 3));
    }
}
