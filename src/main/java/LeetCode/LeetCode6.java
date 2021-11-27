package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-14 11:52 上午
 */
public class LeetCode6 {

    public static void main(String[] args) {
        LeetCode6 leetCode6 = new LeetCode6();
        System.out.println(leetCode6.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        if (numRows == 0 || numRows == 1) {
            return s;
        }

        boolean flag = true;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(cur).append(s.charAt(i));

            if (flag) {
                cur++;
            } else {
                cur--;
            }

            if (cur == 0 || cur == numRows - 1) {
                flag = !flag;
            }

        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }

        return res.toString();
    }

}
