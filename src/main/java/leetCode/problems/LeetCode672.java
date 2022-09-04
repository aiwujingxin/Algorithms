package leetCode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/21 17:57
 */
public class LeetCode672 {

    public static void main(String[] args) {
        System.out.println(new LeetCode672().flipLights(1, 1));
        System.out.println(new LeetCode672().flipLights(2, 1));
        System.out.println(new LeetCode672().flipLights(3, 1));
        System.out.println(new LeetCode672().flipLights(3, 3));
    }

    public int flipLights(int n, int presses) {

        if (n == 0) {
            return 0;
        }
        if (presses == 0) {
            return 1;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1; //开
        }
        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int count = 0;
        queue.add(arr);
        while (!queue.isEmpty()) {
            if (count == presses) {
                break;
            }
            int size = queue.size();
            visited = new HashSet<>();
            while (size > 0) {

                int[] cur = queue.poll();
                List<int[]> nextList = get(cur);
                for (int[] next : nextList) {
                    String s = str(next);
                    if (visited.contains(s)) {
                        continue;
                    }
                    queue.add(next);
                    visited.add(s);
                }
                size--;
            }
            count++;
        }
        return visited.size();
    }

    private List<int[]> get(int[] arr) {

        List<int[]> list = new ArrayList<>();
        // case1
        int[] one = copy(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                one[i] = 0;
            } else {
                one[i] = 1;
            }
        }
        list.add(one);

        //case2
        int[] two = copy(arr);
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) % 2 == 1) {
                if (arr[i] == 0) {
                    two[i] = 1;
                } else {
                    two[i] = 0;
                }
            }
        }
        list.add(two);
        //case3
        int[] three = copy(arr);
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) % 2 == 0) {
                if (arr[i] == 0) {
                    three[i] = 1;
                } else {
                    three[i] = 0;
                }
            }
        }
        list.add(three);

        //case4
        int[] four = copy(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i % 3 == 1) {
                if (arr[i - 1] == 0) {
                    four[i - 1] = 1;
                } else {
                    four[i - 1] = 0;
                }
            }
        }
        list.add(four);
        return list;
    }

    private String str(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int j : arr) {
            sb.append(j);
        }
        return sb.toString();
    }

    private int[] copy(int[] arr) {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }
}
