package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/13 11:46
 * <a href="https://leetcode.com/problems/regular-expression-matching/solutions/1005244/java-top-down-memoization-solution-beats-100-in-runtime/">...</a>
 */
public class LeetCode10_dfs_order_memo {
    int[][] memo; // 0 indicates haven't found, -1 is not possible, 1 is possible!

    public boolean isMatch(String s, String p) {
        memo = new int[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }

    public boolean dfs(String s, String p, int p1, int p2) {
        // let's check if we got to the end
        if (p1 == s.length()) {
            // advance retarded cases like "", "c*c*"
            while (p2 < p.length() - 1 && p.charAt(p2 + 1) == '*') {
                p2 += 2;
            }
            // did we get to the end?
            if (p2 == p.length()) {
                memo[p1][p2] = 1;
                return true;
            } else {
                memo[p1][p2] = -1;
                return false;
            }
            // still have characters left!
        } else if (p2 == p.length()) {
            memo[p1][p2] = -1;
            return false;
        } else if (p1 > s.length() || p2 > p.length()) {
            return false;
        }

        if (memo[p1][p2] == -1) {
            return false;
        }
        if (memo[p1][p2] == 1) {

            return true;
        }

        boolean possible = false;

        // left a bunch of ifs, and elseif for clarity
        if (p.charAt(p2) == '.') {
            // no more characters or the next character isn't a start -- advance both
            if (p.length() - 1 == p2 || p.charAt(p2 + 1) != '*') {
                possible = dfs(s, p, p1 + 1, p2 + 1);
            } else if (p.charAt(p2 + 1) == '*')
                // advance 0, found more than one character, or found one character
                possible = dfs(s, p, p1, p2 + 2) || dfs(s, p, p1 + 1, p2) || dfs(s, p, p1 + 1, p2 + 2);
        } else {
            if (s.charAt(p1) == p.charAt(p2)) {
                if (p.length() - 1 == p2 || p.charAt(p2 + 1) != '*') {
                    possible = dfs(s, p, p1 + 1, p2 + 1);
                } else if (p.charAt(p2 + 1) == '*') {
                    possible = dfs(s, p, p1, p2 + 2) || dfs(s, p, p1 + 1, p2) || dfs(s, p, p1 + 1, p2 + 2);
                }
                // zero of these characters
            } else if (p.length() - 1 != p2 && p.charAt(p2 + 1) == '*') {
                // ex. s = "i", p = "s*"; -- don't advance s!
                possible = dfs(s, p, p1, p2 + 2);
            }
        }
        memo[p1][p2] = possible ? 1 : -1;
        return possible;
    }
}
