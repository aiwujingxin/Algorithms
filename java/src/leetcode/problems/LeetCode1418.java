package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/29 15:57
 */
public class LeetCode1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {

        HashSet<String> foods = new HashSet<>();
        HashSet<Integer> tables = new HashSet<>();
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();

        for (int i = 0; i < orders.size(); i++) {
            String tableNum = orders.get(i).get(1);
            String food = orders.get(i).get(2);

            foods.add(food);
            tables.add(Integer.parseInt(tableNum));

            HashMap<String, Integer> m = map.getOrDefault(tableNum, new HashMap<>());
            m.put(food, m.getOrDefault(food, 0) + 1);
            map.put(tableNum, m);
        }
        List<String> list = new ArrayList<>(foods);
        Collections.sort(list);

        List<List<String>> res = new ArrayList<>();
        List<String> head = new ArrayList<>(list);
        head.add(0, "Table");
        res.add(head);
        List<Integer> ts = new ArrayList<>(tables);
        Collections.sort(ts);


        for (Integer tableNum : ts) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(tableNum));
            for (int i = 0; i < foods.size(); i++) {
                int num = map.get(String.valueOf(tableNum)).getOrDefault(list.get(i), 0);
                row.add(String.valueOf(num));
            }
            res.add(row);
        }
        return res;
    }
}
