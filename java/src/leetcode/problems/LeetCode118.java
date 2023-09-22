package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-12-16 12:36 AM
 */
public class LeetCode118 {

    public static void main(String[] args) {
        System.out.println(new LeetCode118().generate(1));
    }


    public List<List<Integer>> generate(int numRows) {

        if (numRows == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);

        //1 0
        //1 1

        for (int i = 1; i < numRows; i++) {
            List<Integer> last = res.get(i - 1);
            List<Integer> cur = new ArrayList<>();
            last.add(0);
            cur.add(1);
            for (int j = 1; j < last.size(); j++) {
                cur.add(j, last.get(j) + last.get(j - 1));
            }
            last.remove(last.size() - 1);
            res.add(cur);
        }
        return res;

    }
}
