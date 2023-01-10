package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-11-27 2:37 下午
 */
public class Offer62 {

    public static void main(String[] args) {
        System.out.println(new Offer62().lastRemaining(5, 3));
        System.out.println(new Offer62().lastRemaining(10, 17));

        //case
        System.out.println(new Offer62().lastRemaining(71989, 111059));
    }

    public int lastRemaining(int n, int m) {
        if (n == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        helper(list, m, 0);
        return list.get(0);
    }

    private void helper(List<Integer> list, int m, int start) {
        int temp = (m - 1) + start;
        int index = temp % list.size();
        list.remove(index);
        if (list.size() == 1) {
            return;
        }
        helper(list, m, index);
    }
}
