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
        int i = 0, n = words.length;

        while (i < n) {
            // 1. 确定当前行可放置的单词范围 [i, j)
            int j = i + 1;
            int lineLen = words[i].length(); // 当前行基础长度（含单词间默认的1个空格）
            while (j < n && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j++].length();
            }
            StringBuilder sb = new StringBuilder(words[i]);
            int gaps = j - i - 1; // 单词间的间隔数
            // 2. 特殊情况：最后一行 或 只有一个单词 -> 左对齐
            if (j == n || gaps == 0) {
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ").append(words[k]);
                }
                sb.append(" ".repeat(maxWidth - sb.length())); // 尾部补齐剩余空格
            } else { // 3. 一般情况：左右两端对齐 -> 均匀分配空格
                int totalSpaces = maxWidth - lineLen + gaps; // 总共需要分配的空格数
                int spacePerGap = totalSpaces / gaps;        // 每个间隔的基础空格数
                int extraSpaces = totalSpaces % gaps;        // 左侧需要多加1个空格的间隔数
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ".repeat(spacePerGap + (extraSpaces-- > 0 ? 1 : 0)));
                    sb.append(words[k]);
                }
            }
            res.add(sb.toString());
            i = j; // 推进到下一行
        }
        return res;
    }
}
