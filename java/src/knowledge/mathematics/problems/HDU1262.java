package knowledge.mathematics.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 01:12
 * @description 给定一个偶数 M 的时候，找到两个素数 A 和 B，使得 A+B=M，并且 A与 B的差的绝对值 ∣A−B∣ 最小。 5 < M ≤10^5
 */
public class HDU1262 {

    public class Main {
        // 题目最大范围是 10000
        static final int MAX_N = 10005;
        // notPrime[i] = true 表示 i 是合数，false 表示 i 是质数
        static boolean[] notPrime = new boolean[MAX_N];

        public static void main(String[] args) {
            // 1. 预处理：使用埃氏筛法筛出 10000 以内的质数
            sieve();

            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int m = sc.nextInt();
                solve(m);
            }
        }

        // 埃氏筛法预处理质数
        static void sieve() {
            // 0 和 1 不是质数
            notPrime[0] = true;
            notPrime[1] = true;

            for (int i = 2; i * i < MAX_N; i++) {
                if (!notPrime[i]) {
                    for (int j = i * i; j < MAX_N; j += i) {
                        notPrime[j] = true;
                    }
                }
            }
        }

        static void solve(int m) {
            // 从中间 m/2 开始寻找
            // A 从 m/2 向下递减，B 从 m/2 向上递增
            // 这样找到的第一对肯定差值最小
            int half = m / 2;
            for (int i = 0; i < half; i++) {
                int a = half - i;
                int b = half + i;
                if (!notPrime[a] && !notPrime[b]) {
                    System.out.println(a + " " + b);
                    return;
                }
            }
        }
    }
}
