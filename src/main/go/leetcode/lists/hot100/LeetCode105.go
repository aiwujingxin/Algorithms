package hot100

func buildTree(preorder []int, inorder []int) *TreeNode {
	var buildTree func([]int, int, int, []int, int, int) *TreeNode

	buildTree = func(preorder []int, p_start int, p_end int,
		inorder []int, i_start int, i_end int) *TreeNode {
		if p_start > p_end || i_start > i_end {
			return nil
		}
		val, leftLen, index := preorder[p_start], 0, p_start
		for index < len(inorder) && inorder[index] != val {
			index++
			leftLen++
		}
		node := &TreeNode{
			Val: val,
		}
		node.Left = buildTree(preorder, p_start+1, p_start+leftLen, inorder, i_start, index-1)
		node.Right = buildTree(preorder, p_start+leftLen+1, p_end, inorder, index+1, i_end)
		return node
	}
	return buildTree(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1)
}
