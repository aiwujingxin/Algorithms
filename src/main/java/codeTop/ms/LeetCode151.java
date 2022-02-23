package codeTop.ms;

import java.util.Objects;

/**
 * @author jingxinwu
 * @date 2022-02-17 1:08 PM
 */
public class LeetCode151 {

    public static void main(String[] args) {
        System.out.println(new LeetCode151().reverseWords("a good   example"));
    }


    public String reverseWords(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        String newStr = helper(s);

        String[] strings = newStr.split(" ");
        StringBuilder res = new StringBuilder();
        for (String string : strings) {

            //fix "" 而不是 " "
            if (Objects.equals(string, "")) {
                continue;
            }
            res.append(helper(string)).append(" ");

        }
        return res.toString().trim();
    }

    public String helper(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}

