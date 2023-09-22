package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/22 22:06
 */
public class LeetCode1104_TEL {

    public static void main(String[] args) {
        System.out.println(new LeetCode1104_TEL().pathInZigZagTree(14));
        System.out.println(new LeetCode1104_TEL().pathInZigZagTree(26));

//        for (int i = 1; i <= 4; i++) {
//            for (int j = 0; j < (int) Math.pow(2, i - 1); j++) {
//                System.out.print(new LeetCode1104().getValue(i, j));
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
    }

    List<Integer> res;
    int label;

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> temp = new ArrayList<>();
        if (label == 1) {
            temp.add(1);
            return temp;
        }
        this.label = label;
        backtrack(1, 0, temp);
        return res;
    }

    private void backtrack(int level, int index, List<Integer> temp) {
        if (!temp.isEmpty() && temp.get(temp.size() - 1) > label) {
            return;
        }
        if (!temp.isEmpty() && temp.get(temp.size() - 1) == label) {
            res = new ArrayList<>(temp);
            return;
        }
        int size = (int) Math.pow(2, level - 1);
        int value = getValue(level, index);
        temp.add(value);
        for (int i = 0; i < size; i++) {
            backtrack(level + 1, 2 * index, temp);
            backtrack(level + 1, 2 * index + 1, temp);
        }
        temp.remove(temp.size() - 1);
    }

    private int getValue(int level, int index) {
        int last = (int) Math.pow(2, level - 1) - 1;
        if (level % 2 == 1) {
            return last + index + 1;
        }
        return last + (int) Math.pow(2, level - 1) - index;
    }
}
