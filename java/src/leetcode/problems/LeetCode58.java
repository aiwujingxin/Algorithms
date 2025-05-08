package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 23:51
 */
public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        int j = i;
        while (j >= 0 && s.charAt(j) != ' ') j--;
        return i - j;
    }
}
