package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 17:45
 */
public class LeetCode247 {

    //==fast==
    char[][] map = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    //==DFS
    public List<String> findStrobogrammatic(int n) {
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        if (n == 2) {
            return new ArrayList<>(Arrays.asList("11", "69", "88", "96"));
        }

        List<String> list = dfs(n - 2);
        List<String> res = new ArrayList<>();

        for (String sub : list) {
            res.add("1" + sub + "1");
            res.add("6" + sub + "9");
            res.add("8" + sub + "8");
            res.add("9" + sub + "6");
        }
        return res;
    }

    private List<String> dfs(int n) {
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
        if (n == 2) {
            return new ArrayList<>(Arrays.asList("11", "69", "88", "96", "00"));
        }
        List<String> subs = dfs(n - 2);
        List<String> res = new ArrayList<>();
        for (String sub : subs) {
            res.add("0" + sub + "0");
            res.add("1" + sub + "1");
            res.add("6" + sub + "9");
            res.add("9" + sub + "6");
            res.add("8" + sub + "8");
        }
        return res;
    }

    public List<String> findStrobogrammatic_fast(int n) {
        List<String> res = new ArrayList<>();
        char[] temp = new char[n];
        backTrack(res, temp, 0, n);
        return res;
    }

    private void backTrack(List<String> res, char[] cur, int count, int n) {
        if (count > (n - 1) / 2) {
            res.add(new String(cur));
            return;
        }
        if (n % 2 == 1 && count == (n - 1) / 2) {
            for (int i = 0; i < 3; i++) {
                cur[count] = map[i][0];
                backTrack(res, cur, count + 1, n);
            }
        } else {
            int i = count == 0 ? 1 : 0;
            for (; i < map.length; i++) {
                cur[count] = map[i][0];
                cur[n - 1 - count] = map[i][1];
                backTrack(res, cur, count + 1, n);
            }
        }
    }

    //==TEL=
    public List<String> findStrobogrammatic_TEL(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, 0, new StringBuilder());
        return res;
    }

    private void dfs(List<String> res, int n, int index, StringBuilder sb) {

        if (sb.length() == n) {
            if (isStrobogrammatic(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            sb.append(i);
            dfs(res, n, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public boolean isStrobogrammatic(String num) {
        if (num.length() > 1 && num.charAt(0) == '0') {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            sb.append(map.get(num.charAt(i)));
        }
        char[] chars = sb.toString().toCharArray();
        reverse(chars, 0, chars.length - 1);

        return new String(chars).equals(num);
    }

    public void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
    }
}
