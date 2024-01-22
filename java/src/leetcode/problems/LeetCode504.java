package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 17:14
 */
public class LeetCode504 {

    public String convertToBase7(int num) {
        String sign = "";
        if (num < 0) {
            num = -num;
            sign = "-";
        }
        StringBuilder res = new StringBuilder();
        while (num >= 7) {
            int yu = num % 7;
            res.insert(0, yu);
            num = num / 7;
        }
        res.insert(0, num);
        res.insert(0, sign);
        return res.toString();
    }
}
