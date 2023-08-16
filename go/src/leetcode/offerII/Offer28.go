package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/15 14:02
 */

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/solutions/2728002/java-4-solutions-iteration-recursive-constant-space/
//指针赋值
func flatten(root *Node) *Node {
	if root == nil {
		return root
	}
	cur := &Node{}
	var dfs func(node *Node)
	dfs = func(node *Node) {
		if node == nil {
			return
		}
		cur.Next = node
		node.Prev = cur
		cur = cur.Next
		last := node.Next
		if node.Child != nil {
			dfs(node.Child)
			node.Child = nil
		}
		if last != nil {
			dfs(last)
		}
	}
	dfs(root)
	root.Prev = nil
	return root
}
