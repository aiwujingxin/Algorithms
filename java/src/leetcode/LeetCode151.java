package leetcode;

/**
 * @author jingxinwu
 * @date 2021-08-04 11:14 下午
 */
public class LeetCode151 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        String[] list = s.trim().split("\\s+");

        for (int i = list.length - 1; i >= 0; i--) {
            sb.append(list[i]).append(" ");
        }
        return sb.toString().trim();
    }

}
