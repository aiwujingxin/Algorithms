package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/11/25 22:19
 */
public class LeetCode2129 {

    public String capitalizeTitle(String title) {
        char[] chars = title.toCharArray();
        int index = 0;
        while (index < chars.length) {
            int j = index;
            while (j < chars.length && chars[j] != ' ') {
                chars[j] = Character.toLowerCase(chars[j]);
                j++;
            }
            if (j - index > 2) {
                chars[index] = Character.toUpperCase(chars[index]);
            }
            index = j + 1;
        }
        return new String(chars);
    }
}
