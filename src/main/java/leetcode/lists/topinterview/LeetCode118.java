package leetcode.lists.topinterview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/23 23:07
 */
public class LeetCode118 {

    //[1,3,3,1],
    //  [1,3,3,1]
    //[1,4,6,4,1]

    public static void main(String[] args) {
        System.out.println(new LeetCode118().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {

        if (numRows <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> last = res.get(res.size() - 1);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < last.size(); j++) {
                list.add(last.get(j) + last.get(j - 1));
            }
            list.add(1);
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
