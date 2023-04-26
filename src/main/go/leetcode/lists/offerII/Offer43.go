package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 19:32
 */

type CBTInserter struct {
	root      *TreeNode
	candidate []*TreeNode
}

func ConstructorCBTInserter(root *TreeNode) CBTInserter {
	q := []*TreeNode{root}
	var candidate []*TreeNode
	for len(q) > 0 {
		node := q[0]
		q = q[1:]
		if node.Left != nil {
			q = append(q, node.Left)
		}
		if node.Right != nil {
			q = append(q, node.Right)
		}
		if node.Left == nil || node.Right == nil {
			candidate = append(candidate, node)
		}
	}
	return CBTInserter{root, candidate}
}

func (this *CBTInserter) Insert(v int) int {
	child := &TreeNode{Val: v}
	node := this.candidate[0]
	if node.Left == nil {
		node.Left = child
	} else {
		node.Right = child
		this.candidate = this.candidate[1:]
	}
	this.candidate = append(this.candidate, child)
	return node.Val
}

func (this *CBTInserter) Get_root() *TreeNode {
	return this.root
}
