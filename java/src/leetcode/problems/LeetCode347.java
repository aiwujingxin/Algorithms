package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 22:34
 * @description 堆排 桶排 快排
 */
public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int n = Math.min(k, pq.size());
        int[] res = new int[n];
        while (!pq.isEmpty()) {
            res[n - 1] = pq.poll()[0];
            n--;
        }
        return res;
    }

    // O（n）
    public int[] topKFrequent_bucket(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        List<Integer>[] arr = new List[n + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (arr[entry.getValue()] == null) {
                arr[entry.getValue()] = new ArrayList<>();
            }
            arr[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] == null) {
                continue;
            }
            for (int l = 0; l < arr[j].size(); l++) {
                res[index] = arr[j].get(l);
                index++;
                if (index == k) {
                    break;
                }
            }
            if (index == k) {
                break;
            }
        }
        return res;
    }

    // O（n）
    public int[] topKFrequent_quick(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        quickSelect(list, k, 0, list.size() - 1);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = list.get(i)[0];
        }
        return ret;
    }

    public void quickSelect(List<int[]> list, int k, int lo, int hi) {
        if (lo >= hi) return;
        int index = partition(list, lo, hi);
        int rank = index + 1;
        if (rank == k) return;
        if (rank > k) quickSelect(list, k, lo, index - 1);
        quickSelect(list, k, index + 1, hi);
    }

    private int partition(List<int[]> nums, int i, int j) {
        int[] pi = nums.get(i);
        while (i < j) {
            while (i < j && nums.get(j)[1] <= pi[1]) j--;
            nums.set(i, nums.get(j));
            while (i < j && nums.get(i)[1] >= pi[1]) i++;
            nums.set(j, nums.get(i));
        }
        nums.set(i, pi);
        return i;
    }
}
