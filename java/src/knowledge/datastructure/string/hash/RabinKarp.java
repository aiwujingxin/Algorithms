package knowledge.datastructure.string.hash;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/7 00:09
 * @description RabinKarp  Rabin-Karp 算法：通过滚动哈希将字符串比较转化为整数比较，从而加速匹配。平均时间复杂度 O(N+M)。
 */
public class RabinKarp implements knowledge.datastructure.string.String.Match {

    public int strStr(String txt, String pat) {
        int n = pat.length();
        int mul = 256;
        long mod = 1658598167;
        long pow = 1;
        for (int i = 0; i < n - 1; i++) {
            pow = pow * mul % mod; // 计算过程中不断求模，避免溢出
        }
        long target = 0;
        for (int i = 0; i < pat.length(); i++) {
            target = (mul * target + pat.charAt(i)) % mod;
        }
        long hash = 0;
        int left = 0;
        int right = 0;
        while (right < txt.length()) {
            hash = ((mul * hash) % mod + txt.charAt(right)) % mod;
            if (right - left + 1 == n) {
                if (hash == target) {
                    if (pat.equals(txt.substring(left, right + 1))) {
                        return left;
                    }
                }
                // 因为 hash - (txt[left] * pow) % mod 可能是负数 再加一个 mod，保证 hash 不会是负数
                hash = (hash - (txt.charAt(left) * pow) % mod + mod) % mod;
                left++;
            }
            right++;
        }
        return -1;
    }
}
