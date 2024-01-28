package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/28 14:40
 */
public class LeetCode1946 {

    public String maximumNumber(String num, int[] change) {
        char[] chars = num.toCharArray();
        int index = 0;
        boolean flag = false;
        while (index < num.length()) {
            if (flag) {// 优化
                break;
            }
            if (num.charAt(index) - '0' < change[num.charAt(index) - '0'] && !flag) {
                flag = true;
                while (index < num.length() && (num.charAt(index) - '0') <= change[num.charAt(index) - '0']) {
                    chars[index] = (char) (change[num.charAt(index) - '0'] + '0');
                    index++;
                }
            } else {
                index++;
            }
        }
        return new String(chars);
    }
}
