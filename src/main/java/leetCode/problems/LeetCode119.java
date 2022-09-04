package leetCode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-12-16 12:36 AM
 */
public class LeetCode119 {

    public static void main(String[] args) {
        System.out.println(new LeetCode119().getRow(2));
    }

    //[1,1]
    //[1 2, 1]
    //[1 2 ,1 0]
    //[1 3 ,3 1]

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
