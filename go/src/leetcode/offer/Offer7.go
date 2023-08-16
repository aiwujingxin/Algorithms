package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 15:00
 */

func buildTree(preorder []int, inorder []int) *TreeNode {
	var dfs func(preorder []int, pi int, pe int, inorder []int, ii int, ie int) *TreeNode
	dfs = func(preorder []int, pi int, pe int, inorder []int, ii int, ie int) *TreeNode {
		if pi > pe || ii > ie {
			return nil
		}
		root := &TreeNode{
			Val: preorder[pi],
		}
		index, leftLen := ii, 0
		for index < ie && inorder[index] != preorder[pi] {
			index++
			leftLen++
		}
		root.Left = dfs(preorder, pi+1, pi+leftLen, inorder, ii, index-1)
		root.Right = dfs(preorder, pi+leftLen+1, pe, inorder, index+1, ie)
		return root
	}
	return dfs(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1)
}
