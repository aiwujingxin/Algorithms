package offerII

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type ListNode struct {
	Val  int
	Next *ListNode
}

type Node struct {
	Val   int
	Prev  *Node
	Next  *Node
	Child *Node
}

type Iheap []int

func (h Iheap) Len() int           { return len(h) }
func (h Iheap) Less(i, j int) bool { return h[i] <= h[j] }
func (h Iheap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *Iheap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *Iheap) Pop() interface{} {
	old := *h
	n := len(old)
	*h = old[:n-1]
	return old[n-1]
}
