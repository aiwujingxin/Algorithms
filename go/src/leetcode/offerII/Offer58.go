package offerII

import "fmt"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/1 16:19
 */

// MyCalendar https://leetcode.cn/problems/fi9suh/solution/jian-zhi-offer-ii-058golangqie-pian-er-f-wftr/
// redblacktree https://leetcode.cn/problems/fi9suh/solutions/1072156/hong-hei-shu-by-scorix-0ko2/
type AVLNode struct {
	Left, Right *AVLNode    // 表示指向左孩子和右孩子
	Date        interface{} // 结点存储数据
	Height      int         // 记录这个结点此时的高度
}

// RightRotate LL型，顺时针旋转，右旋
func (avlNode *AVLNode) RightRotate() *AVLNode {
	//旋转
	headNode := avlNode.Left
	avlNode.Left = headNode.Right
	headNode.Right = avlNode

	// 更新高度
	// 先更新 avlNode，后更新 headNode，自下而上
	avlNode.Height = Max(avlNode.Left.GetHeight(), avlNode.Right.GetHeight()) + 1
	headNode.Height = Max(headNode.Left.GetHeight(), headNode.Right.GetHeight()) + 1

	return headNode
}

// LeftRotate RR型，逆时针旋转，左旋
func (avlNode *AVLNode) LeftRotate() *AVLNode {
	//旋转
	headNode := avlNode.Right
	avlNode.Right = headNode.Left
	headNode.Left = avlNode

	// 更新高度
	// 先更新 avlNode，后更新 headNode，自下而上
	avlNode.Height = Max(avlNode.Left.GetHeight(), avlNode.Right.GetHeight()) + 1
	headNode.Height = Max(headNode.Left.GetHeight(), headNode.Right.GetHeight()) + 1

	return headNode
}

// LeftThenRightRotate LR型，先逆时针旋转再顺时针旋转，先左旋，在右旋
func (avlNode *AVLNode) LeftThenRightRotate() *AVLNode {
	// 先左孩子进行左旋
	avlNode.Left = avlNode.Left.LeftRotate()
	// 然后自己进行右旋
	return avlNode.RightRotate()
}

// RightThenLeftRotate RL型，先顺时针旋转再逆时针旋转，先右旋，再左旋
func (avlNode *AVLNode) RightThenLeftRotate() *AVLNode {
	// 先右孩子进行右旋
	avlNode.Right = avlNode.Right.RightRotate()
	// 然后自己进行右旋
	return avlNode.LeftRotate()
}

// adjust 调整AVL树的平衡
func (avlNode *AVLNode) adjust() *AVLNode {
	if avlNode.Right.GetHeight()-avlNode.Left.GetHeight() == 2 {
		// 如果右子树的高度比左子树的高度大于2，R型
		if avlNode.Right.Right.GetHeight() > avlNode.Right.Left.GetHeight() {
			// 如果 avlNode.Right 的右子树的高度大于 avlNode.Right 的左子树高度，RR型
			// 那么就直接对 avlNode 进行左旋
			avlNode = avlNode.LeftRotate()
		} else {
			// 否则先对 avlNode.Right进行右旋转，然后对 avlNode 进行左旋，RL型
			avlNode = avlNode.RightThenLeftRotate()
		}
	} else if avlNode.Right.GetHeight()-avlNode.Left.GetHeight() == -2 {
		// 如果左子树的高度比右子树的高度大2
		if avlNode.Left.Left.GetHeight() > avlNode.Left.Right.GetHeight() {
			// 如果 avlNode.Left 的左子树高度大于 avlNode.Left 的右子树高度，LL型
			// 那么就直接对 avlNode 进行右旋
			avlNode = avlNode.RightRotate()
		} else {
			// 否则先对 avlNode.Left 进行左旋，然后对 avlNode 进行右旋，LR型
			avlNode = avlNode.LeftThenRightRotate()
		}
	}

	return avlNode
}

// NewAVLNode 新建一个结点
func NewAVLNode(data interface{}) *AVLNode {
	return &AVLNode{
		Left:   nil,
		Right:  nil,
		Date:   data,
		Height: 1,
	}
}

// Compare 比较两个值
func Compare(left, right interface{}) int {
	a := left.([]int)[0]
	b := right.([]int)[0]
	if a < b {
		return -1
	} else if a > b {
		return 1
	} else {
		return 0
	}
}

// GetData 获取结点数据
func (avlNode *AVLNode) GetData() interface{} {
	return avlNode.Date
}

// SetData 设置结点数据
func (avlNode *AVLNode) SetData(data interface{}) {
	if avlNode == nil {
		return
	}
	avlNode.Date = data
}

// GetRight 获取结点的右孩子结点
func (avlNode *AVLNode) GetRight() *AVLNode {
	if avlNode == nil {
		return nil
	}
	return avlNode.Right
}

// GetLeft 获取结点的左孩子结点
func (avlNode *AVLNode) GetLeft() *AVLNode {
	if avlNode == nil {
		return nil
	}
	return avlNode.Left
}

// GetHeight 获取结点的高度
func (avlNode *AVLNode) GetHeight() int {
	if avlNode == nil {
		return 0
	}
	return avlNode.Height
}

// Max 比较两个子树高度的大小
func Max(a, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}

// Find 查找指定值
func (avlNode *AVLNode) Find(data interface{}) *AVLNode {
	var found *AVLNode
	// 调用比较函数比较两个结点的值的大小
	switch Compare(data, avlNode.Date) {
	case -1:
		found = avlNode.Left.Find(data)
	case 1:
		found = avlNode.Right.Find(data)
	case 0:
		return avlNode
	}

	return found
}

// FindMin 查找最小值
func (avlNode *AVLNode) FindMin() *AVLNode { // 递归写法
	var found *AVLNode

	if avlNode.Left != nil {
		found = avlNode.Left.FindMin()
	} else {
		found = avlNode
	}

	return found
}

// FindMax 查找最大值
func (avlNode *AVLNode) FindMax() *AVLNode {
	var found *AVLNode

	if avlNode.Right != nil {
		found = avlNode.Right.FindMax()
	} else {
		found = avlNode
	}

	return found
}

// PrevNode 查找小于等于目标值的最大值
func (avlNode *AVLNode) PrevNode(data interface{}) *AVLNode {
	if avlNode == nil {
		return nil
	}
	var found *AVLNode
	// 调用比较函数比较两个结点的值的大小
	switch Compare(data, avlNode.Date) {
	case -1:
		return avlNode.Left.PrevNode(data)
	case 1:
		found = avlNode.Right.PrevNode(data)
		if found != nil {
			return found
		}
	case 0:
		return avlNode
	}
	return avlNode
}

// NextNode 查找大于等于目标值的最小值
func (avlNode *AVLNode) NextNode(data interface{}) *AVLNode {
	if avlNode == nil {
		return nil
	}
	var found *AVLNode
	// 调用比较函数比较两个结点的值的大小
	switch Compare(data, avlNode.Date) {
	case -1:
		found = avlNode.Left.NextNode(data)
		if found != nil {
			return found
		}
	case 1:
		return avlNode.Right.NextNode(data)
	case 0:
		return avlNode
	}
	return avlNode
}

// Insert 插入数据
// 因为没有定义结点的parent指针，所以插入数据就只能递归的插入，因为我要调整树的平衡和高度
func (avlNode *AVLNode) Insert(data interface{}) *AVLNode {
	if avlNode == nil {
		return NewAVLNode(data)
	}

	switch Compare(data, avlNode.Date) {
	case -1:
		// 如果value 小于 avlNode.Data 那么就在avlNode的左子树上去插入value
		avlNode.Left = avlNode.Left.Insert(data)
		avlNode = avlNode.adjust() // 自动调整平衡
	case 1:
		avlNode.Right = avlNode.Right.Insert(data)
		avlNode = avlNode.adjust()
	case 0:
		fmt.Print("数据已经存在")
	}
	// 修改结点的高度
	avlNode.Height = Max(avlNode.Left.GetHeight(), avlNode.Right.GetHeight()) + 1

	return avlNode
}

type MyCalendar struct {
	root *AVLNode
}

func Constructor() MyCalendar {
	var root *AVLNode
	return MyCalendar{
		root: root,
	}
}

func (this *MyCalendar) Book(start int, end int) bool {
	prevNode := this.root.PrevNode([]int{start, end})
	nextNode := this.root.NextNode([]int{start, end})
	if this.root == nil ||
		(prevNode == nil && end <= nextNode.Date.([]int)[0]) ||
		(nextNode == nil && prevNode.Date.([]int)[1] <= start) ||
		(prevNode != nil && nextNode != nil && end <= nextNode.Date.([]int)[0] && prevNode.Date.([]int)[1] <= start) {
		this.root = this.root.Insert([]int{start, end})
		return true
	}
	return false
}