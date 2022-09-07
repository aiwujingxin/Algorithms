package leetcode.study.recursive;

import java.util.*;

public class Shop {


    public static void main(String[] args) {

        //商品id      用户id    购买时间 有序
        Map<Long, Map<Long, List<Long>>> map = new HashMap<>();

        Set<Long> res = new HashSet<>();
        for (Map.Entry<Long, Map<Long, List<Long>>> entry1 : map.entrySet()) {
            for (Map.Entry<Long, Map<Long, List<Long>>> entry2 : map.entrySet()) {
                if (Objects.equals(entry1.getKey(), entry2.getKey())) {
                    continue;
                }
                List<Long> temp = find(entry1.getValue(), entry2.getValue());
                if (!temp.isEmpty()) {
                    res.addAll(temp);
                }
            }
        }
    }


    public static List<Long> find(Map<Long, List<Long>> one, Map<Long, List<Long>> two) {

        List<Long> users = new ArrayList<>();

        for (Map.Entry<Long, List<Long>> entry : one.entrySet()) {

            if (two.containsKey(entry.getKey()) &&
                    entry.getValue().get(entry.getValue().size() - 1) - two.get(entry.getKey()).get(0) < 5) {
                users.add(entry.getKey());
            }
        }
        return users;
    }
}
