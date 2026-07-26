package knowledge.datastructure.adv;

/**
 * Sparse Table (ST表)
 * Used for solving Range Minimum/Maximum Query (RMQ) problems.
 * Preprocessing time: O(N log N)
 * Query time: O(1)
 */
public class STTable {
    private int[][] st;
    private int[] log2;

    public STTable(int[] arr) {
        int n = arr.length;
        log2 = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }

        int k = log2[n] + 1;
        st = new int[n][k];

        for (int i = 0; i < n; i++) {
            st[i][0] = arr[i];
        }

        for (int j = 1; j < k; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                st[i][j] = Math.max(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    public int query(int L, int R) {
        int j = log2[R - L + 1];
        return Math.max(st[L][j], st[R - (1 << j) + 1][j]);
    }
}
