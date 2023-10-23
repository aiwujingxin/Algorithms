package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 22:22
 */
public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        int index = s.length();
        int res = 0;
        while (index > 0 && s.charAt(index - 1) == ' ') {
            index--;
        }
        while (index > 0 && s.charAt(index - 1) != ' ') {
            res++;
            index--;
        }
        return res;
    }
}

