package knowledge.mathematics.combinatorics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description Burnside 引理 / Polya 计数
 * <本质>
 * 在群作用下“本质不同”的染色方案数 = 各置换下不动点数的平均值：
 * |X/G| = (1/|G|) · Σ_{g∈G} |Fix(g)|。
 * Polya 定理进一步给出 |Fix(g)| = colors^{c(g)}，c(g) 是置换 g 的循环个数。
 * <典型>
 * 项链/手镯染色、正多边形旋转反射等价类计数、魔方状态计数。
 */
public class BurnsidePolya {

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 仅旋转群 C_n 下，用 colors 种颜色给 n 个珠子的项链染色的等价类数。
     * 旋转 k 位的循环数为 gcd(n,k)，由 Polya：Σ colors^{gcd(n,k)} / n。
     */
    public static long necklaceRotations(int n, int colors) {
        long sum = 0;
        for (int k = 0; k < n; k++) {
            sum += power(colors, gcd(n, k));
        }
        return sum / n;
    }

    /**
     * 二面体群 D_n（旋转 + 反射）下的手镯染色等价类数。
     * 在旋转部分基础上追加 n 个反射轴的不动点贡献。
     */
    public static long braceletDihedral(int n, int colors) {
        long rotation = 0;
        for (int k = 0; k < n; k++) rotation += power(colors, gcd(n, k));
        long reflection;
        if ((n & 1) == 1) {
            reflection = (long) n * power(colors, (n + 1) / 2);
        } else {
            reflection = (long) (n / 2) * power(colors, n / 2)
                    + (long) (n / 2) * power(colors, n / 2 + 1);
        }
        return (rotation + reflection) / (2L * n);
    }

    private static long power(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res *= base;
            base *= base;
            exp >>= 1;
        }
        return res;
    }
}
