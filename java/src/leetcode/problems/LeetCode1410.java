package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 21:52
 */
public class LeetCode1410 {
    public String entityParser(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        return text.replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'")
                .replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<")
                .replaceAll("&frasl;", "/")
                .replaceAll("&amp;", "&");
    }
}
