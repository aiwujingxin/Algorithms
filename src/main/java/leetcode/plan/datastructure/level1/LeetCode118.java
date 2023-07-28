package leetcode.plan.datastructure.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 22:18
 */
public class LeetCode118 {

    public static void main(String[] args) {
        System.out.println(new LeetCode118().generate(5));
    }
    //  1,1
    //1,1

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);
        if (numRows == 1) {
            return list;
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> last = list.get(list.size() - 1);
            ArrayList<Integer> level = new ArrayList<>();
            level.add(1);
            for (int j = 0; j < last.size() - 1; j++) {
                level.add(last.get(j) + last.get(j + 1));
            }
            level.add(1);
            list.add(level);
        }
        return list;
    }
}
