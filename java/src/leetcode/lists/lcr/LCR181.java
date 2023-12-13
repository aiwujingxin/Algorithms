package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 16:47
 */
public class LCR181 {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].isEmpty()) continue; // 遇到空单词则跳过
            char[] cs = ss[i].trim().toCharArray();
            sb.append(cs);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
