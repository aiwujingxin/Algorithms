package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/5 22:57
 */
public class LeetCode809 {

    public int expressiveWords(String s, String[] words) {
        int cnt = 0;
        for (String word : words) {
            if (check(s, word)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean check(String s, String word) {
        if (word.length() > s.length()) {
            return false;
        }
        int j = 0;
        int i = 0;
        while (i < s.length()) {
            if (j >= word.length()) {
                return false;
            }
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            int t = i;
            int tc = 0;
            while (t < s.length() && s.charAt(t) == s.charAt(i)) {
                tc++;
                t++;
            }
            int tt = j;
            int ttc = 0;
            while (tt < word.length() && word.charAt(tt) == word.charAt(j)) {
                ttc++;
                tt++;
            }
            if (tc != ttc) {
                if (tc <= 2 || tc < ttc) {
                    return false;
                }
            }
            i = t;
            j = tt;
        }
        return j == word.length();
    }
}
