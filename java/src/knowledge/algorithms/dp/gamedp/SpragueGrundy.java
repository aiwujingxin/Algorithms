package knowledge.algorithms.dp.gamedp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description SG 函数 (Sprague-Grundy)
 * <适用场景>
 * 求解任意公平组合游戏：把局面抽象成状态，枚举后继取 mex 得到 SG 值；
 * 多个独立游戏的和用各自 SG 值异或判断整体胜负。
 * <核心>
 * SG(x) = mex{ SG(y) : y 是 x 的合法后继 }；SG=0 为必败态。
 * 下例以"1 堆 n 个石子、每次取集合 moves 中的数量"的取石子游戏为例打表。
 * @see NimGame 经典模型可由 SG 推导（Nim 单堆 SG(n)=n）
 */
public class SpragueGrundy {

    /**
     * 取石子游戏：单堆最多 n 个，每步可取 moves 中的任意个，返回 sg[0..n]。
     */
    public static int[] grundy(int n, int[] moves) {
        int[] sg = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Set<Integer> nexts = new HashSet<>();
            for (int m : moves) {
                if (i - m >= 0) nexts.add(sg[i - m]);
            }
            sg[i] = mex(nexts);
        }
        return sg;
    }

    /**
     * mex：集合中缺失的最小非负整数。
     */
    public static int mex(Set<Integer> set) {
        int m = 0;
        while (set.contains(m)) m++;
        return m;
    }

    /**
     * 游戏和：多个独立子游戏 SG 值异或，非 0 则先手必胜。
     */
    public static boolean sumWin(int[] sgValues) {
        int xor = 0;
        for (int v : sgValues) xor ^= v;
        return xor != 0;
    }

    public static void main(String[] args) {
        // 每次取 1、2 或 3 个：SG 呈 0 1 2 3 0 1 2 3 ... 周期 4（等价 Bash 博弈 m=3）
        int[] sg = grundy(8, new int[]{1, 2, 3});
        StringBuilder sb = new StringBuilder();
        for (int v : sg) sb.append(v).append(" ");
        System.out.println("sg[0..8]: " + sb.toString().trim());
        System.out.println("expected: 0 1 2 3 0 1 2 3 0");
        // 三堆分别剩 5、5、8，各自 SG=1、1、0 -> 异或=0 必败
        System.out.println("sum{sg[5],sg[5],sg[8]} win: " + sumWin(new int[]{sg[5], sg[5], sg[8]}));
    }
}
