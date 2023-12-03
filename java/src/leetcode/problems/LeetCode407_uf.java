package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 00:29
 */
public class LeetCode407_uf {

    //https://leetcode.com/problems/trapping-rain-water-ii/solutions/249845/union-find-solution-lakes-and-oceans/
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        List<List<Integer>> hm = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hm.add(Arrays.asList(i, j, heightMap[i][j]));
            }
        }
        hm.sort(Comparator.comparing(a -> a.get(2)));
        WaterCounter wm = new WaterCounter(m, n);
        int volume = 0;
        int i = 0;
        while (i < hm.size()) {
            int j = i + 1;
            while (j < hm.size() && hm.get(j).get(2).equals(hm.get(j - 1).get(2))) {
                j++;
            }
            if (j == hm.size()) {
                break;
            }
            int waterLine = hm.get(j).get(2);
            int lastWaterLine = hm.get(i).get(2);
            for (int k = i; k < j; k++) {
                wm.addWater(hm.get(k).get(0), hm.get(k).get(1));
            }
            volume += (waterLine - lastWaterLine) * wm.countLake();
            i = j;
        }
        return volume;
    }

    static class UnionFind {
        Map<List<Integer>, List<Integer>> parent;
        Map<List<Integer>, Integer> size;
        int setCnt;

        UnionFind(List<List<Integer>> values) {
            parent = new HashMap<>();
            size = new HashMap<>();
            setCnt = values.size();

            for (List<Integer> v : values) {
                parent.put(v, v);
                size.put(v, 1);
            }
        }

        void add(List<Integer> u) {
            parent.put(u, u);
            size.put(u, 1);
            setCnt++;
        }

        boolean has(List<Integer> u) {
            return parent.containsKey(u);
        }

        List<Integer> root(List<Integer> u) {
            while (!u.equals(parent.get(u))) {
                parent.put(u, parent.get(parent.get(u)));
                u = parent.get(u);
            }
            return u;
        }

        boolean find(List<Integer> u, List<Integer> v) {
            return root(u).equals(root(v));
        }

        void union(List<Integer> u, List<Integer> v) {
            List<Integer> ru = root(u);
            List<Integer> rv = root(v);

            if (ru.equals(rv)) {
                return;
            }

            if (size.get(ru) > size.get(rv)) {
                parent.put(rv, ru);
                size.put(ru, size.get(ru) + size.get(rv));
            } else {
                parent.put(ru, rv);
                size.put(rv, size.get(rv) + size.get(ru));
            }
            setCnt--;
        }
    }

    static class WaterCounter {
        int m, n;
        UnionFind ut;

        WaterCounter(int m, int n) {
            this.m = m;
            this.n = n;
            List<List<Integer>> values = new ArrayList<>();
            values.add(Arrays.asList(-1, -1));
            ut = new UnionFind(values);
        }

        void addWater(int x, int y) {
            List<Integer> pos = Arrays.asList(x, y);
            ut.add(pos);

            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] v : dirs) {
                int xx = x + v[0];
                int yy = y + v[1];

                if (xx < 0 || xx == m || yy < 0 || yy == n) {
                    ut.union(pos, Arrays.asList(-1, -1));
                } else if (ut.has(Arrays.asList(xx, yy))) {
                    ut.union(pos, Arrays.asList(xx, yy));
                }
            }
        }

        int countOcean() {
            List<Integer> oceanRoot = ut.root(Arrays.asList(-1, -1));
            return ut.size.get(oceanRoot) - 1;
        }

        int countLake() {
            return ut.parent.size() - 1 - countOcean();
        }
    }
}