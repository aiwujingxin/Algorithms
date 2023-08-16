package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/24 11:31
 */

func mergeKLists(lists []*ListNode) *ListNode {
	if len(lists) == 0 {
		return nil
	}
	merge := func(list1, list2 *ListNode) *ListNode {
		if list1 == nil {
			return list2
		}
		if list2 == nil {
			return list1
		}
		dummy := &ListNode{}
		cur := dummy
		for list1 != nil && list2 != nil {
			if list1.Val < list2.Val {
				cur.Next = list1
				list1 = list1.Next
			} else {
				cur.Next = list2
				list2 = list2.Next
			}
			cur = cur.Next
		}

		for list1 != nil {
			cur.Next = list1
			list1 = list1.Next
		}
		for list2 != nil {
			cur.Next = list2
			list2 = list2.Next
		}
		return dummy.Next
	}
	var mergeLists func(lists []*ListNode, start int, end int) *ListNode
	mergeLists = func(lists []*ListNode, start int, end int) *ListNode {
		if start >= end {
			return lists[start]
		}
		mid := (start + end) / 2
		list1 := mergeLists(lists, start, mid)
		list2 := mergeLists(lists, mid+1, end)
		return merge(list1, list2)
	}
	return mergeLists(lists, 0, len(lists)-1)
}
