package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/12 00:23
 */
public class LeetCode10_dfs_reverse {
    //https://leetcode.com/problems/regular-expression-matching/discuss/1873060/Java-solutions-using-recursive-and-DP
    public boolean isMatch(String s, String p) {
        return solve(s.length() - 1, p.length() - 1, s, p);
    }

    //其实就是分情况讨论
    //基于各种情况，可以构造出转移方程，进而使用dp求解
    public boolean solve(int i, int j, String s, String p) {
        if (j < 0) {
            return (i < 0);
        }
        if (i < 0) {
            return (p.charAt(j) == '*') && solve(i, j - 2, s, p);
        }
        //simple char matching
        //if s char matches with p char, or it can be '.'
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            return solve(i - 1, j - 1, s, p);
        }
        if (p.charAt(j) == '*') {
            //if s char matches with p char, or it can be '.'
            if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                //using * we can take one char, or we can ignore *
                return solve(i - 1, j, s, p) || solve(i, j - 2, s, p);
            }
            // if s char not match with p char
            return solve(i, j - 2, s, p);
        }
        return false;
    }
}
