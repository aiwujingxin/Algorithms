package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/1 16:57
 */
public class LeetCode443 {

    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int index = 0;
        int left = 0;
        int right;
        int n = chars.length;
        while (left < n) {
            char c = chars[left];
            right = left;
            int cnt = 0;
            while (right < n && chars[right] == c) {
                right++;
                cnt++;
            }
            chars[index] = c;
            index++;
            if (cnt > 1) {
                String len = String.valueOf(cnt);
                for (int i = 0; i < len.length(); i++) {
                    chars[index] = len.charAt(i);
                    index++;
                }
            }
            left = right;
        }
        System.out.println(chars);
        return index;
    }
}
