package leetcode.lists.topinterview;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/29 13:34
 */
public class LeetCode234 {


    // study
    //[1,2,2,1]
    //[1,2,3,2,1]
    //[1,2,3,4,3,2,1]
    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
    
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

}
