package leetcode.lists.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 21:15
 */
public class LCR87 {

    //255.255.255.255
    public static void main(String[] args) {
        System.out.println(new LCR87().restoreIpAddresses("25525511135"));
        System.out.println(new LCR87().restoreIpAddresses("0000"));
        System.out.println(new LCR87().restoreIpAddresses("1111"));
        System.out.println(new LCR87().restoreIpAddresses("010010"));
        System.out.println(new LCR87().restoreIpAddresses("10203040"));
    }

    public List<String> restoreIpAddresses(String s) {

        if (s == null || s.isEmpty() || s.length() > 15) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backtrack(s, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int index, List<String> res, List<String> list) {
        if (index == s.length() && list.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
            return;
        }

        for (int j = index; j <= Math.min(index + 3, s.length() - 1); j++) {
            String ip = s.substring(index, j + 1);
            if (ip.length() > 1 && ip.charAt(0) == '0') {
                continue;
            }
            int iip = Integer.parseInt(ip);
            if (iip >= 0 && iip <= 255) {
                list.add(ip);
                backtrack(s, j + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
