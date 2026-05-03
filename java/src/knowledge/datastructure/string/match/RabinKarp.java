package knowledge.datastructure.string.match;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/7 00:09
 * @description RabinKarp  Rabin-Karp 算法：通过滚动哈希将字符串比较转化为整数比较，从而加速匹配。平均时间复杂度 O(N+M)。
 */
public class RabinKarp implements knowledge.datastructure.string.match.StringMatch  {

    public int strStr(String txt, String pat) {
        int m = txt.length(), n = pat.length();
        int BASE = 256;
        long MOD = 1658598167L;
        long pow = 1;
        for (int i = 0; i < n - 1; i++) {
            pow = (pow * BASE) % MOD;
        }
        long patHash = 0, txtHash = 0;
        for (int i = 0; i < n; i++) {
            patHash = (BASE * patHash + pat.charAt(i)) % MOD;
            txtHash = (BASE * txtHash + txt.charAt(i)) % MOD;
        }
        for (int i = 0; i <= m - n; i++) {
            if (txtHash == patHash && txt.substring(i, i + n).equals(pat)) {
                return i;
            }
            if (i < m - n) {
                txtHash = (txtHash - (txt.charAt(i) * pow) % MOD + MOD) % MOD;
                txtHash = (BASE * txtHash + txt.charAt(i + n)) % MOD;
            }
        }
        return -1;
    }
}
