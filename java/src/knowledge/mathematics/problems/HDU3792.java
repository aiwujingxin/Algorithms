package knowledge.mathematics.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 01:21
 * @description - 定义：孪生素数是指差为 2 的两个素数。
 * - 目标：给定 N，求有多少对 (p,p+2) 满足 p+2≤N
 */
public class HDU3792 {

    public class Main {
        static final int MAX_N = 100005;
        static boolean[] notPrime = new boolean[MAX_N];
        static int[] twinCount = new int[MAX_N];

        public static void main(String[] args) {
            init();
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int n = sc.nextInt();
                if (n < 0) break; // 结束条件
                System.out.println(twinCount[n]);
            }
        }

        static void init() {
            notPrime[0] = true;
            notPrime[1] = true;
            for (int i = 2; i * i < MAX_N; i++) {
                if (!notPrime[i]) {
                    for (int j = i * i; j < MAX_N; j += i) {
                        notPrime[j] = true; // 标记合数
                    }
                }
            }
            // --- 2. 统计孪生素数对 (前缀和) ---
            int count = 0;
            for (int i = 0; i < MAX_N; i++) {
                if (i >= 5 && !notPrime[i] && !notPrime[i - 2]) {
                    count++;
                }
                twinCount[i] = count;
            }
        }
    }
}
