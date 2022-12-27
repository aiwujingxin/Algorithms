package hot100

func mergeKLists(lists []*ListNode) *ListNode {
	if len(lists) == 0 {
		return nil
	}
	var mergeKLists func([]*ListNode, int, int) *ListNode
	mergeKLists = func(lists []*ListNode, left int, right int) *ListNode {
		if left >= right {
			return lists[left]
		}
		mid := (right - left) / 2
		list1 := mergeKLists(lists, left, mid)
		list2 := mergeKLists(lists, mid+1, right)
		return mergeList(list1, list2)
	}
	return mergeKLists(lists, 0, len(lists)-1)
}
