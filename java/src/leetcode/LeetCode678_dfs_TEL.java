package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/13 22:47
 */

//https://leetcode.com/problems/valid-parenthesis-string/solutions/107566/java-12-lines-solution-backtracking/


    /*

   1. How to check valid parenthesis w/ only ( and )?
     Easy. Count each char from left to right.
     When we see (, count++; when we see ) count--;
     if count < 0, it is invalid () is more than ();
     At last, count should == 0.
   2. This problem added *. The easiest way is to try 3 possible ways when we see it.
    Return true if one of them is valid.
    */
public class LeetCode678_dfs_TEL {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }

    private boolean check(String s, int start, int count) {
        if (count < 0) {
            return false;
        }
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count <= 0) {
                    return false;
                }
                count--;
            } else if (c == '*') {
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }
        return count == 0;
    }
}
