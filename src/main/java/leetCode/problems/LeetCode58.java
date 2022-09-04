package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-11-18 11:00 下午
 */
public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        int len = s.length(), lastLength = 0;
        while (len > 0 && s.charAt(len - 1) == ' ') {
            len--;
        }

        while (len > 0 && s.charAt(len - 1) != ' ') {
            lastLength++;
            len--;
        }

        return lastLength;
    }
}
