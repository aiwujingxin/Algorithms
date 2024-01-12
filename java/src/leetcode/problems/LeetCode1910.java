package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/12 16:49
 */
public class LeetCode1910 {

    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int i = sb.indexOf(part);
//        int i = new KMP().search(sb.toString(), part);
        while (i != -1) {
            sb.delete(i, i + part.length());
            i = sb.indexOf(part);
        }
        return sb.toString();
    }
}
