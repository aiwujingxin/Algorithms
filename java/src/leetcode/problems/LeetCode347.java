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

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});

            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index] = queue.poll()[0];
            index++;
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
        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            values.add(new int[]{entry.getKey(), entry.getValue()});
        }
        findKthLargest(values, k);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = values.get(i)[0];
        }
        return ret;
    }

    public void findKthLargest(List<int[]> nums, int k) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index + 1 == k) {
                return;
            } else if (index + 1 > k) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
    }

    private int partition(List<int[]> nums, int i, int j) {
        int[] pi = nums.get(i);
        while (i < j) {
            while (i < j && nums.get(j)[1] <= pi[1]) {
                j--;
            }
            nums.set(i, nums.get(j));
            while (i < j && nums.get(i)[1] >= pi[1]) {
                i++;
            }
            nums.set(j, nums.get(i));
        }
        nums.set(i, pi);
        return i;
    }
}
