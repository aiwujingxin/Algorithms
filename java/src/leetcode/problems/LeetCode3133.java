package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 5/5/26 16:31
 */
public class LeetCode3133 {
    public long minEnd(int n, int x) {
        long result = x;
        long remaining = n - 1L; // 使用 long 类型，防止后续移位操作溢出
        int bitPos = 0;

        while (remaining > 0) {
            // 找 x 的下一个 0-bit 位置
            // 注意：x 转换为 long 再移位，或者直接判断 result 的对应位
            while (((long) x >> bitPos & 1) == 1) {
                bitPos++;
            }

            // 将 n-1 的对应 bit 嵌入该位置
            if ((remaining & 1) == 1) {
                result |= (1L << bitPos); // 必须使用 1L，否则当 bitPos >= 32 时会溢出/截断
            }

            remaining >>= 1;
            bitPos++;
        }

        return result;
    }
}
