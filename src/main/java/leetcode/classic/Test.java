package leetcode.classic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author jingxinwu
 * @date 2021-12-10 11:02 下午
 */
public class Test {

    public static void main(String[] args) {

//        System.out.println(new Test().getPositions(new int[]{-1, 2, 1, 1, 1, -1}, 0));//0,2 | 0,3 | 0,4 25 35 45
        System.out.println(new Test().test(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2}, 3));//0,2 | 0,3 | 0,4 25 35 45
        System.out.println(new Test().getPositions(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2}, 3));//0,2 | 0,3 | 0,4 25 35 45

    }


    class ArraySet {

        public int[] array;

        @Override
        public boolean equals(Object input) {
            int[] arr = (int[]) input;
            return arr[0] == array[0] && arr[1] == array[1];
        }

    }

    public List<int[]> test(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<int[]> res = new ArrayList<>();
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        Map<Integer, HashSet<Integer>> map1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> s;
            if (!map.containsKey(nums[i])) {
                s = new HashSet<>();
            } else {
                s = map.get(nums[i]);
            }
            s.add(i);
            map.put(nums[i], s);
        }

        for (int value : map.keySet()) {
            HashSet<Integer> cur = map.get(value);
            HashSet<Integer> set = map.get(target - value);
            if (set == null || set.size() == 0) {
                continue;
            }
            for (int i : cur) {
                for (int j : set) {
                    if (j == i) {
                        continue;
                    }
                    if (canAdd(map1, i, j)) {
                        res.add(new int[]{i, j});
                        addMap(map1, i, j);
                        addMap(map1, j, i);
                    }
                }
            }
        }
        return res;
    }

    private void addMap(Map<Integer, HashSet<Integer>> map1, int first, int second) {
        HashSet<Integer> set = map1.containsKey(first) ? map1.get(first) : new HashSet<>();
        set.add(second);
        map1.put(first, set);
    }

    private boolean canAdd(Map<Integer, HashSet<Integer>> map1, int i, int j) {
        if (map1.get(j) != null && map1.get(j).contains(i)) {
            return false;
        }
        if (map1.get(i) != null && map1.get(i).contains(j)) {
            return false;
        }
        return true;
    }

    public List<int[]> getPositions(int[] array, int target) {

        List<int[]> statistic_list = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] + array[j] == target) {
                    statistic_list.add(new int[]{j, i});
                }
            }
        }
        return statistic_list;
    }

}
