package knowledge.mathematics.combinatorics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 欧拉数 (Eulerian Number)
 * <本质>
 * A(n,k) 统计 1..n 的排列中恰有 k 个“升高位”(位置 i 满足 a_i < a_{i+1}) 的排列数。
 * <递推>
 * A(n,k)=(k+1)·A(n-1,k)+(n-k)·A(n-1,k-1)，边界 A(0,0)=1。
 * 每行之和为 n!；worthy 用于研究排列的上升/下降结构与 Worpitzky 恒等式。
 */
public class EulerianNumber {

    /**
     * 欧拉数全表 A[n][k] 对 mod 取模，0<=n<=maxN, 0<=k<maxN。
     */
    public static long[][] eulerian(int maxN, long mod) {
        long[][] a = new long[maxN + 1][maxN + 1];
        a[0][0] = 1 % mod;
        for (int n = 1; n <= maxN; n++) {
            a[n][0] = 1 % mod;
            for (int k = 1; k < n; k++) {
                a[n][k] = ((k + 1) * a[n - 1][k] + (n - k) * a[n - 1][k - 1]) % mod;
            }
        }
        return a;
    }
}
