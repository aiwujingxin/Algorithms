package knowledge.datastructure.string.match;

import knowledge.datastructure.string.hash.StringHash;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/26 18:13
 */
public class HashMatch implements knowledge.datastructure.string.match.StringMatch {

    public int strStr(String text, String pat) {
        if (pat.isEmpty()) return 0;
        int n = text.length(), m = pat.length();
        StringHash th = new StringHash(text);
        StringHash ph = new StringHash(pat);
        long target = ph.getHash(0, pat.length());
        for (int i = 0; i <= n - m; i++) {
            if (th.getHash(i, i + m) == target) {
                if (text.substring(i, i + m).equals(pat)) return i;
            }
        }
        return -1;
    }


}
