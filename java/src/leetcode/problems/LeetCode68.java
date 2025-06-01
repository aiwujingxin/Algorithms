package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 15:32
 */
public class LeetCode68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int j = i + 1, len = words[i].length();
            while (j < words.length && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j++].length();
            }
            int spaces = maxWidth - len + (j - i - 1); // total spaces to insert
            StringBuilder sb = new StringBuilder(words[i]);
            if (j == words.length || j - i == 1) {
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ").append(words[k]);
                }
                sb.append(" ".repeat(maxWidth - sb.length()));
            } else {
                int gaps = j - i - 1;
                int space = spaces / gaps, extra = spaces % gaps;
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ".repeat(space + (extra-- > 0 ? 1 : 0)));
                    sb.append(words[k]);
                }
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}
