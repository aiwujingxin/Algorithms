package leetcode.problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 00:10
 */
public class LeetCode1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int s : students) {
            queue.offerLast(s);
        }
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        while (!stack.isEmpty() && queue.contains(stack.peek())) {
            if (Objects.equals(stack.peek(), queue.peek())) {
                stack.pop();
                queue.removeFirst();
            } else {
                int student = queue.pollFirst();
                queue.addLast(student);
            }
        }
        return queue.size();
    }
}
