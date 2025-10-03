package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/3/25 13:57
 * <a href="https://leetcode.cn/problems/convert-to-base-2/solutions/2759014/javapython3cmo-ni-shu-xue-jin-zhi-zhuan-9j7na/"></a>
 */
public class LeetCode1017 {

    public String baseNeg2(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;      // 余数（0 或 1）
            sb.append(remainder);
            n -= remainder;
            n /= -2;                    // 商作为下一轮 n
        }
        return sb.reverse().toString(); // 反转得到最终结果
    }

    public String base2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            res.append(remainder);
            n -= remainder;
            n /= 2;
        }
        return res.reverse().toString();
    }
}
