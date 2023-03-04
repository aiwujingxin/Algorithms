package leetcode.competition.doubleweekly.week99;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/3/4 22:39
 */
public class LeetCode6312 {

    public int splitNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                a.append(chars[i]);
            } else {
                b.append(chars[i]);
            }
        }
        return Integer.parseInt(a.toString()) + Integer.parseInt(b.toString());
    }
}
