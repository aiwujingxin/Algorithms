package knowledge.datastructure.string.match;

import knowledge.datastructure.string.hash.DStringHash;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/26 18:14
 */
public class HashMatchD implements knowledge.datastructure.string.match.StringMatch {

    public int strStr(String text, String pat) {
        if (pat.isEmpty()) return 0;
        int n = text.length();
        int m = pat.length();
        if (m > n) return -1;
        DStringHash textHash = new DStringHash(text);
        DStringHash patHash = new DStringHash(pat);
        long[] targetHash = patHash.getHash(0, m);
        for (int i = 0; i <= n - m; i++) {
            long[] currentHash = textHash.getHash(i, i + m);
            if (currentHash[0] == targetHash[0] && currentHash[1] == targetHash[1]) {
                return i;
            }
        }
        return -1;
    }
}
