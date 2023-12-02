package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/27 14:58
 */
public class LeetCode401 {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (cal(h) + cal(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }

    private int cal(int num) {
        int cnt = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                cnt++;
            }
            num >>= 1;
        }
        return cnt;
    }

    public List<String> readBinaryWatch_self(int turnedOn) {
        if (turnedOn == 0) {
            List<String> list = new ArrayList<>();
            list.add("0:00");
            return list;
        }
        List<String> res = new ArrayList<>();
        String[] hours = new String[]{"1", "2", "4", "8"};
        String[] mins = new String[]{"1", "2", "4", "8", "16", "32"};
        for (int i = 0; i <= turnedOn; i++) {
            List<Integer> hs = new ArrayList<>();
            List<Integer> ms = new ArrayList<>();
            get(0, i, hours, hs, 0, 11);
            get(0, turnedOn - i, mins, ms, 0, 59);
            for (Integer h : hs) {
                for (Integer m : ms) {
                    if (h == 0 && m == 0) {
                        continue;
                    }
                    res.add(h + ":" + (m <= 9 ? "0" + m : m));
                }
            }
        }
        return res;
    }

    private void get(int index, int cnt, String[] strings, List<Integer> res, int sum, int max) {
        if (sum > max) {
            return;
        }
        if (0 == cnt) {
            res.add(sum);
            return;
        }
        for (int i = index; i < strings.length; i++) {
            sum += Integer.parseInt(strings[i]);
            cnt--;
            get(i + 1, cnt, strings, res, sum, max);
            sum -= Integer.parseInt(strings[i]);
            cnt++;
        }
    }

}
