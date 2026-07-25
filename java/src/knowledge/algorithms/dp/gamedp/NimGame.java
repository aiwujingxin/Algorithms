package knowledge.algorithms.dp.gamedp;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 经典博弈模型 (Nim / Bash / Wythoff)
 * <核心>
 * Nim 博弈：n 堆石子每次任取一堆拿任意个，先手必胜当且仅当所有堆异或和 ≠ 0。
 * Bash 博弈：1 堆 n 个，每次拿 1~m 个，先手必败当且仅当 n % (m+1) == 0。
 * Wythoff 博弈：2 堆，每次从一堆拿任意个或从两堆拿相同个，
 *   必败态为 (⌊kφ⌋, ⌊kφ²⌋)，φ=(1+√5)/2，即两堆差 d 对应较小堆 ⌊d·φ⌋。
 * @see SpragueGrundy SG 函数通用解法
 */
public class NimGame {

    /**
     * Nim 博弈：返回先手是否必胜。
     */
    public static boolean nimWin(int[] piles) {
        int xor = 0;
        for (int p : piles) xor ^= p;
        return xor != 0;
    }

    /**
     * Bash 博弈：1 堆 n 个，每次取 1~m 个，返回先手是否必胜。
     */
    public static boolean bashWin(int n, int m) {
        return n % (m + 1) != 0;
    }

    /**
     * Wythoff 博弈：两堆 a、b，返回先手是否必胜（false 表示当前为必败态）。
     */
    public static boolean wythoffWin(int a, int b) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        double phi = (1 + Math.sqrt(5)) / 2;
        int k = (int) ((b - a) * phi);
        return k != a;
    }

    public static void main(String[] args) {
        System.out.println("nim{1,2,3} expect false(P): " + nimWin(new int[]{1, 2, 3}));
        System.out.println("nim{1,2,4} expect true(N): " + nimWin(new int[]{1, 2, 4}));
        System.out.println("bash(4,3) expect false(P): " + bashWin(4, 3));
        System.out.println("wythoff(1,2) expect false(P): " + wythoffWin(1, 2));
        System.out.println("wythoff(3,5) expect false(P): " + wythoffWin(3, 5));
    }
}
