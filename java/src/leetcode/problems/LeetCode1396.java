package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/28 20:01
 */
public class LeetCode1396 {

    class UndergroundSystem {

        static class Node {
            String name;
            Integer t;

            public Node(String name, Integer t) {
                this.name = name;
                this.t = t;
            }
        }

        HashMap<Integer, List<Node[]>> map;
        HashMap<String, List<Integer>> listMap;

        public UndergroundSystem() {
            this.map = new HashMap<>();
            this.listMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            List<Node[]> list = map.getOrDefault(id, new ArrayList<>());
            list.add(new Node[]{new Node(stationName, t), null});
            map.put(id, list);
        }

        public void checkOut(int id, String stationName, int t) {
            Node[] last = find(map.get(id));
            last[1] = new Node(stationName, t);
            List<Integer> list = listMap.getOrDefault(last[0].name + "_" + stationName, new ArrayList<>());
            list.add(t - last[0].t);
            listMap.put(last[0].name + "_" + stationName, list);
        }

        private Node[] find(List<Node[]> list) {
            int l = 0;
            int r = list.size() - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (list.get(mid)[1] != null) l = mid + 1;
                else r = mid;
            }
            return list.get(l);
        }

        public double getAverageTime(String startStation, String endStation) {
            List<Integer> list = listMap.get(startStation + "_" + endStation);
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            return (double) sum / list.size();
        }
    }
}
