package leetcode.offer;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-11-24 12:51 上午
 */
public class Offer50 {

    public char firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return ' ';
        }

        Map<Character, Boolean> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }

        for (Map.Entry<Character, Boolean> d : map.entrySet()) {
            if (d.getValue()) {
                return d.getKey();
            }
        }
        return ' ';
    }


    public char firstUniqCharV2(String s) {
        Map<Character, Integer> position = new HashMap<>();
        //使用一个额外的队列，按照顺序存储每一个字符以及它们第一次出现的位置
        Queue<Pair> queue = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                //延迟删除
                //即使队列中有一些字符出现了超过一次，但它只要不位于队首，那么就不会对答案造成影响，我们也就可以不用去删除它。
                //只有当它前面的所有字符被移出队列，它成为队首时，我们才需要将它移除。
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? ' ' : queue.poll().ch;
    }

    class Pair {

        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }
}
