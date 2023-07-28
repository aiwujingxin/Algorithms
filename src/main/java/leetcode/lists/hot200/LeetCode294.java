package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/14 19:05
 */
public class LeetCode294 {

    //石子游戏

    private final Map<String, Boolean> hmap = new HashMap<>();

    //思路就是遍历所有的可能被flip的++对，将其替换为--得到新的string，
    // 然后递归再判断新生成的string是不是可以赢，如果不能赢说明只要构造出string下一轮的选手就赢不了->
    // 这代表能构造出这个string的人可以赢，因此返回true。全程注意保存结果便于后续加速查找算过的结果。

    public boolean canWin(String s) {
        if (hmap.containsKey(s)) {
            return hmap.get(s);
        }

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                String ss = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                if (!canWin(ss)) {
                    hmap.put(ss, false);
                    return true;
                }
                hmap.put(ss, true);
            }
        }
        return false;
    }
}
