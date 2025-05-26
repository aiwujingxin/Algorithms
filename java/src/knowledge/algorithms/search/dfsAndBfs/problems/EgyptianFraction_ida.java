package knowledge.algorithms.search.dfsAndBfs.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 5/22/25 00:29
 * @description 埃及分数  IDA*
 * @link <a href="https://www.acwing.com/solution/content/21686/"></a>
 */

public class EgyptianFraction_ida {
    static int maxd;
    static int N = 1000;
    static int[] ans = new int[N];   // 最优解
    static int[] temp = new int[N];  // 当前解

    // 比较 temp 是否优于 ans，temp 更优返回 true
    static boolean cmp(int d) {
        if (ans[d] == 0) return true;
        return temp[d] < ans[d];
    }

    // 获取小于 a/b 最大的 1/x 的分母 x
    static long getFirst(long a, long b) {
        return b / a + 1;
    }

    // 最大公约数
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // d: 递归深度，last: 当前可选最小分母, a/b: 当前剩余分数
    static boolean dfs(int d, long last, long a, long b) {
        if (d == maxd) {
            if (b % a != 0 || b > 1e7) { // 最后一个数不是埃及分数，剪枝
                return false;
            }
            temp[d] = (int) (b / a);
            if (d > 0 && temp[d] <= temp[d - 1]) return false; // 确保分母递增
            if (cmp(d)) {
                System.arraycopy(temp, 0, ans, 0, ans.length);
            }
            return true;
        }
        boolean flag = false;
        last = Math.max(last, getFirst(a, b));
        for (long i = last; ; i++) {
            // 估价函数剪枝
            if (b * (maxd + 1 - d) <= i * a) {
                break;
            }
            temp[d] = (int) i;

            // 分数减去 1/i
            long a1 = a * i - b;
            long b1 = b * i;
            long g = gcd(a1, b1);
            a1 /= g;
            b1 /= g;

            if (dfs(d + 1, i + 1, a1, b1)) {
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        long g = gcd(a, b);
        a /= g;
        b /= g;

        for (maxd = 1; ; maxd++) {
            if (dfs(0, getFirst(a, b), a, b)) {
                break;
            }
        }

        for (int i = 0; i <= maxd; i++) {
            System.out.print(ans[i] + (i == maxd ? "\n" : " "));
        }
    }
}
