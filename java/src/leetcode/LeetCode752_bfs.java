package leetcode;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/11 17:58
 */
public class LeetCode752_bfs {

    public static void main(String[] args) {

        System.out.println(new LeetCode752_bfs().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));

        System.out.println(new LeetCode752_bfs().openLock(new String[]{"0000"}, "8888"));
    }

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add("0000");
        HashSet<String> seen = new HashSet<>();
        seen.add("0000");
        HashSet<String> dead = new HashSet<>();
        Collections.addAll(dead, deadends);
        if (dead.contains("0000")) {
            return -1;
        }
        int step = 0;

        while (!q.isEmpty()) {
            ++step;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String cur = q.poll();
                List<String> list = get(cur);
                for (String next : list) {
                    if (!dead.contains(next) && !seen.contains(next)) {
                        if (next.equals(target)) {
                            return step;
                        }
                        q.offer(next);
                        seen.add(next);
                    }
                }
            }
        }
        return -1;
    }

    List<String> get(String cur) {
        List<String> list = new ArrayList<>();
        char[] arr = cur.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            arr[i] = getPre(c);
            list.add(new String(arr));
            arr[i] = getNext(c);
            list.add(new String(arr));
            arr[i] = c;
        }
        return list;
    }

    private char getNext(char c) {
        if (c == '9') {
            return '0';
        }
        return (char) (c + 1);
    }

    private char getPre(char c) {
        if (c == '0') {
            return '9';
        }
        return (char) (c - 1);
    }
}
