package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 00:25
 */
public class LeetCode2734 {

    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length && chars[index] == 'a') {
            index++;
        }
        if (index == chars.length) {
            chars[index - 1] = 'z';
            return String.valueOf(chars);
        }
        while (index < chars.length && chars[index] != 'a') {
            chars[index]--;
            index++;
        }
        return String.valueOf(chars);
    }
}
