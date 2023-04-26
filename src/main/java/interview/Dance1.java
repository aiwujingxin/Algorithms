package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-03-22 15:12
 */
public class Dance1 {

    /**
     * 华东经济圈十个核心城市，编号0-9
     * 2.现修建高速公路串联十个城市，形成一个环路
     * 3.每个城市的出入口可上可下，但是只能开往编号临近的城市
     * 4.编写一个路径规划程序，求解汽车出发从X城市出发中途经过N个城市返回X的走法
     * 5.例如：从编号0出发，中途经过3个城市返回起点0，
     * 则走法6种(0-9-8-9-0，0-1-2-1-0，0-1-0-1-0，0-9-0-9-0，0-1-0-9-0，0-9-0-1-0)
     *
     * @author ronaldwu
     * @date 2022-03-22 15:12:47
     **/

    public static void main(String[] args) {
        Dance1 d = new Dance1();
        System.out.println(d.cal(0, 15));
    }

    public int cal(int start, int count) {
        List<List<Integer>> res = new ArrayList<>();
        helper(new ArrayList<>(), start, start, count + 2, res);
        return res.size();
    }

    private void helper(ArrayList<Integer> list, int start, int next, int count, List<List<Integer>> res) {
        if (list.size() > count) {
            return;
        }
        if (next == -1) {
            next = 9;
        }
        if (next == 10) {
            next = 0;
        }
        list.add(next);
        if (list.size() == count && list.get(list.size() - 1) == start) {
            res.add(new ArrayList<>(list));
        } else {
            helper(list, start, next + 1, count, res);
            helper(list, start, next - 1, count, res);
        }
        list.remove(list.size() - 1);
    }
}