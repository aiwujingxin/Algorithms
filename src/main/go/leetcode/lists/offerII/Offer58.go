package offerII

import (
	_ "github.com/emirpasic/gods/containers"
	"github.com/emirpasic/gods/trees/redblacktree"

	"math"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/1 16:19
 */

// MyCalendar https://leetcode.cn/problems/fi9suh/solution/jian-zhi-offer-ii-058golangqie-pian-er-f-wftr/
type MyCalendar struct {
	*redblacktree.Tree
}

func ConstructorMyCalendar() MyCalendar {
	t := redblacktree.NewWithIntComparator()
	t.Put(math.MaxInt32, nil) // 哨兵，简化代码
	return MyCalendar{t}
}

func (c MyCalendar) Book(start, end int) bool {
	node, _ := c.Ceiling(end)
	it := c.IteratorAt(node)
	if !it.Prev() || it.Value().(int) <= start {
		c.Put(start, end)
		return true
	}
	return false
}
