package knowledge.mathematics.combinatorics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 贝尔数 (Bell Number)
 * <本质>
 * B(n) 是 n 个不同元素划分成任意个非空无标号集合的方案总数，即 B(n)=Σ_{k=0}^{n} S(n,k)。
 * <贝尔三角>
 * a(0,0)=1；每行首项 = 上一行末项：a(i,0)=a(i-1,i-1)；
 * 行内 a(i,j)=a(i,j-1)+a(i-1,j-1)。每行首项即 B(i)，O(n^2) 递推。
 */
public class BellNumber {

    /**
     * 用贝尔三角求 B(0)..B(n) 对 mod 取模。
     */
    public static long[] bell(int n, long mod) {
        long[][] triangle = new long[n + 1][];
        triangle[0] = new long[]{1 % mod};
        long[] result = new long[n + 1];
        result[0] = 1 % mod;
        for (int i = 1; i <= n; i++) {
            triangle[i] = new long[i + 1];
            triangle[i][0] = triangle[i - 1][i - 1];
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = (triangle[i][j - 1] + triangle[i - 1][j - 1]) % mod;
            }
            result[i] = triangle[i][0];
        }
        return result;
    }
}
