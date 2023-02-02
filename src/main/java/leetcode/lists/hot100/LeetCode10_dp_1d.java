package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/13 11:44
 * <a href="https://leetcode.com/problems/regular-expression-matching/solutions/5829/java-4ms-dp-solution-with-o-n-2-time-and-o-n-space-beats-95/">...</a>
 */
public class LeetCode10_dp_1d {
    public boolean isMatch(String s, String p) {
        /*
         * This solution is assuming s has no regular expressions.
         *
         * dp: res[i][j]=is s[0,...,i-1] matched with p[0,...,j-1];
         *
         * If p[j-1]!='*', res[i][j] = res[i-1][j-1] &&
         * (s[i-1]==p[j-1]||p[j-1]=='.'). Otherwise, res[i][j] is true if
         * res[i][j-1] or res[i][j-2] or
         * res[i-1][j]&&(s[i-1]==p[j-2]||p[j-2]=='.'), and notice the third
         * 'or' case includes the first 'or'.
         *
         *
         * Boundaries: res[0][0]=true;//s=p="". res[i][0]=false, i>0.
         * res[0][j]=is p[0,...,j-1] empty, j>0, and so res[0][1]=false,
         * res[0][j]=p[j-1]=='*'&&res[0][j-2].
         *
         * O(n) space is enough to store a row of res.
         */

        int m = s.length(), n = p.length();
        boolean[] res = new boolean[n + 1];
        res[0] = true;

        int i, j;
        for (j = 2; j <= n; j++) {
            res[j] = res[j - 2] && p.charAt(j - 1) == '*';
        }

        char pc, sc, tc;
        boolean pre, cur; // pre=res[i - 1][j - 1], cur=res[i-1][j]

        for (i = 1; i <= m; i++) {
            pre = res[0];
            res[0] = false;
            sc = s.charAt(i - 1);
            for (j = 1; j <= n; j++) {
                cur = res[j];
                pc = p.charAt(j - 1);
                if (pc != '*') {
                    res[j] = pre && (sc == pc || pc == '.');
                } else {
                    // pc == '*' then it has a preceding char, i.e. j>1
                    tc = p.charAt(j - 2);
                    res[j] = res[j - 2] || (res[j] && (sc == tc || tc == '.'));
                }
                pre = cur;
            }
        }
        return res[n];
    }
}
