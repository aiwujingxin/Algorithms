package knowledge.math.impl;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 22:55
 * @description 因子
 */
public class Factors {

    public int Factors(int number) {
        HashSet<Integer> factors = new HashSet<>();
        for (int i = 1; i <= number; ++i) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors.size();
    }

    public int PrimeFactors(int num) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                set.add(i);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) {
            set.add(num);
        }
        return set.size();
    }
}
