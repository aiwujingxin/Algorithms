package knowledge.mathematics.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 00:51
 * @description 巨大区间素数统计 a < b <= 10^12, b-a<=10^6
 */
public class POJ2689 {

    public class Main {

        // 预处理的质数范围，sqrt(2^31) 约为 46340，开到 50000 足够
        static final int MAX_SQRT = 50000;
        // 区间长度限制
        static final int MAX_RANGE = 1000005;

        // 存储小范围的质数
        static int[] smallPrimes = new int[MAX_SQRT];
        static int smallPrimeCount = 0;
        static boolean[] isSmallNotPrime = new boolean[MAX_SQRT];

        // 存储区间 [L, U] 的筛选结果
        // rangeNotPrime[i] 表示 L + i 这个数是不是合数
        // false 表示是质数，true 表示是合数
        static boolean[] rangeNotPrime = new boolean[MAX_RANGE];

        public static void main(String[] args) throws IOException {
            // 1. 预处理 50000 以内的质数 (欧拉筛)
            preComputeSmallPrimes();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;

            // 处理多组输入
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 2) continue;

                long L = Long.parseLong(parts[0]);
                long U = Long.parseLong(parts[1]);

                solve(L, U);
            }
        }

        // 预处理小质数
        static void preComputeSmallPrimes() {
            isSmallNotPrime[0] = isSmallNotPrime[1] = true;
            for (int i = 2; i < MAX_SQRT; i++) {
                if (!isSmallNotPrime[i]) {
                    smallPrimes[smallPrimeCount++] = i;
                }
                for (int j = 0; j < smallPrimeCount && i * smallPrimes[j] < MAX_SQRT; j++) {
                    isSmallNotPrime[i * smallPrimes[j]] = true;
                    if (i % smallPrimes[j] == 0) break;
                }
            }
        }

        static void solve(long L, long U) {
            // 2. 初始化区间数组
            // rangeNotPrime[i] 对应实际数值 L + i
            int rangeLen = (int) (U - L + 1);
            Arrays.fill(rangeNotPrime, 0, rangeLen, false);

            // 3. 用小质数筛掉大区间 [L, U] 内的合数
            for (int i = 0; i < smallPrimeCount; i++) {
                long p = smallPrimes[i];

                // 如果 p * p 已经超过 U，后面的质数更不用看了
                if (p * p > U) break;

                // 找到第一个大于等于 L 的 p 的倍数
                // 公式推导：(L + p - 1) / p * p
                long start = (L + p - 1) / p * p;

                // 特殊情况：如果 L 很小，start 可能是 p 本身，但 p 是质数不能筛掉
                // 所以要从 2*p 开始筛
                if (start < p * 2) {
                    start = p * 2;
                }

                // 从 start 开始，每次加 p，标记为合数
                for (long j = start; j <= U; j += p) {
                    // 将实际数值 j 映射到数组下标 j - L
                    rangeNotPrime[(int) (j - L)] = true;
                }
            }

            // 4. 遍历区间，收集统计信息
            // 注意：如果 L=1，1 不是质数，需要手动标记
            if (L == 1) {
                rangeNotPrime[0] = true;
            }

            long prevPrime = -1;

            long minDist = Long.MAX_VALUE;
            long c1 = -1, c2 = -1;

            long maxDist = Long.MIN_VALUE;
            long d1 = -1, d2 = -1;

            for (int i = 0; i < rangeLen; i++) {
                if (!rangeNotPrime[i]) {
                    long currentPrime = L + i;

                    if (prevPrime != -1) {
                        long dist = currentPrime - prevPrime;

                        // 更新最近距离
                        if (dist < minDist) {
                            minDist = dist;
                            c1 = prevPrime;
                            c2 = currentPrime;
                        }

                        // 更新最远距离
                        if (dist > maxDist) {
                            maxDist = dist;
                            d1 = prevPrime;
                            d2 = currentPrime;
                        }
                    }
                    prevPrime = currentPrime;
                }
            }

            // 5. 输出结果
            if (c1 == -1) {
                System.out.println("There are no adjacent primes.");
            } else {
                System.out.println(c1 + "," + c2 + " are closest, " + d1 + "," + d2 + " are most distant.");
            }
        }
    }

}
