package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 14:58
 */

func reversePrint(head *ListNode) []int {
	list := make([]int, 0)
	var dfs func(head *ListNode)
	dfs = func(head *ListNode) {
		if head == nil {
			return
		}
		dfs(head.Next)
		list = append(list, head.Val)
	}
	dfs(head)
	return list
}
