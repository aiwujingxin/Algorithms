package knowledge.mathematics.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 01:17
 * @description 给定 N 个数，求哪个数的最大质因子最大。
 */
public class HDU2710 {

    public class Main {
        static final int MAX_VAL = 20005;
        // maxPrimeFactor[i] 存储数字 i 的最大质因子
        static int[] maxPrimeFactor = new int[MAX_VAL];

        public static void main(String[] args) {
            // 1. 预处理：计算 1~20000 每个数的最大质因子
            init();
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int n = sc.nextInt();
                int ansNumber = 0;
                int currentMaxPF = -1;
                for (int i = 0; i < n; i++) {
                    int val = sc.nextInt();
                    int pf = maxPrimeFactor[val];
                    if (pf > currentMaxPF) {
                        currentMaxPF = pf;
                        ansNumber = val;
                    }
                }
                System.out.println(ansNumber);
            }
        }

        // 使用类似埃氏筛的方法预处理
        static void init() {
            maxPrimeFactor[1] = 1;
            for (int i = 2; i < MAX_VAL; i++) {
                if (maxPrimeFactor[i] == 0) {
                    maxPrimeFactor[i] = i;
                    for (int j = i * 2; j < MAX_VAL; j += i) {
                        maxPrimeFactor[j] = i;
                    }
                }
            }
        }
    }
}
