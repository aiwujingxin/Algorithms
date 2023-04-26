package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/25 15:24
 * https://leetcode.cn/problems/rank-from-stream-lcci/solution/by-mumuxinfei-m9sm/
 */

type StreamRank struct {
	root *RankNode
}

func ConstructorStreamRank() StreamRank {
	return StreamRank{}
}

func (this *StreamRank) Track(x int) {
	this.root = this.root.add(this.root, x)
}

func (this *StreamRank) GetRankOfNumber(x int) int {
	return this.root.dfs(this.root, x)
}

type RankNode struct {
	left, right *RankNode
	val         int
	num         int
}

func (r *RankNode) dfs(root *RankNode, x int) int {
	if root == nil {
		return 0
	}
	if x >= root.val {
		var l int
		if root.left == nil {
			l = 0
		} else {
			l = root.left.num
		}
		return l + 1 + r.dfs(root.right, x)
	} else {
		return r.dfs(root.left, x)
	}
}

func (r *RankNode) add(root *RankNode, x int) *RankNode {
	if root == nil {
		return &RankNode{
			val: x,
			num: 1,
		}
	}
	if x <= root.val {
		root.left = r.add(root.left, x)
	} else {
		root.right = r.add(root.right, x)
	}
	// ?
	root.num++
	return root
}
