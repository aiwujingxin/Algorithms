package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/3 23:36
 */
public class LeetCode44_greedy {

    //https://www.youtube.com/watch?v=-8QnRMyHo_o
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int match = 0;
        int star = -1;

        while (sp < s.length()) {
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                star = pp;
                match = sp;
                pp++;

            } else if (star != -1) {
                pp = star + 1;
                match++;
                sp = match;
            } else {
                return false;
            }
        }
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }

        return pp == p.length();
    }
}
