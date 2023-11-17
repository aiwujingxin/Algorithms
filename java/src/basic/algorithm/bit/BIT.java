package basic.algorithm.bit;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 01:29
 */
public interface BIT {

    default void bit() {
        // 取二进制最后一个1
        // n & -n

        // 去掉末尾 1
        // n - (n & -n)
        // n & (n - 1)

        // 末尾是否为 1
        // (n & 1) == 1
    }
}
