package knowledge.math.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 22:53
 * @description 质数
 */
public class Prime {

    public boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
