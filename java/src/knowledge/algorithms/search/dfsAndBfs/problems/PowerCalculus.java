package knowledge.algorithms.search.dfsAndBfs.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 5/22/25 00:22
 * @description Power Calculus IDA*
 * @link <a href="http://poj.org/problem?id=3134"></a>
 * 给定数x和n，求x的n次方, 只能用乘法和除法。问最少算多少次就够了。n<=1000
 */
public class PowerCalculus {

    static int[] val = new int[1010]; // 搜索路径上每一步的计算结果
    static int pos, n;

    public static boolean ida(int now, int depth) {
        if (now > depth) return false;

        // 启发式剪枝：即使每一步都翻倍，也达不到 n，就剪掉
        if ((val[pos] << (depth - now)) < n) return false;

        if (val[pos] == n) return true;

        pos++;
        for (int i = 0; i < pos; i++) {
            // 尝试加法
            val[pos] = val[pos - 1] + val[i];
            if (ida(now + 1, depth)) return true;

            // 尝试减法
            val[pos] = Math.abs(val[pos - 1] - val[i]);
            if (ida(now + 1, depth)) return true;
        }
        pos--;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n == 0) break;

            int depth = 0;
            while (true) {
                pos = 0;
                val[0] = 1;
                if (ida(0, depth)) {
                    System.out.println(depth);
                    break;
                }
                depth++;
            }
        }
    }
}
