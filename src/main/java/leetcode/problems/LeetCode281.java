package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/12 14:43
 */
public class LeetCode281 {


    int maxCol;
    int row;
    int col;

    List<List<Integer>> list = new ArrayList<>();


    public void ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        maxCol = Math.max(v1.size(), v2.size());
        row = 0;
        col = 0;
        list.add(v1);
        list.add(v2);
        while (list.get(row).size() == 0) {
            row++;
        }
    }

    public int next() {
        if (row == list.size() || col >= this.list.get(row).size()) {
            col++;
            row = 0;
        }
        while (row < this.list.size() && col >= this.list.get(row).size()) {
            row++;
        }

        int val = list.get(row).get(col);
        row++;
        return val;
    }

    public boolean hasNext() {
        int nextRow = row;
        int nextCol = col;

        if (nextRow == list.size() || nextCol >= this.list.get(nextRow).size()) {
            nextCol++;
            nextRow = 0;
        }

        if (nextCol == maxCol) {

            return false;
        }
        while (nextRow < list.size() && nextCol >= this.list.get(nextRow).size()) {
            nextRow++;
        }

        return nextRow < list.size();
    }
}
