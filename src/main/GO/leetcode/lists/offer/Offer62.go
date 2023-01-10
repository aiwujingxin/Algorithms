package offer

import "fmt"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 23:54
 */

//https://leetcode.cn/problems/elimination-game/
//https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/jian-zhi-offer-62-yuan-quan-zhong-zui-ho-dcow/
//约瑟夫环
//动态规划
func lastRemaining(n int, m int) int {
	x := 0
	for i := 2; i <= n; i++ {
		x = (x + m) % i
	}
	return x
}

func lastRemaining_TEL(n int, m int) int {
	list := make([]int, 0)

	for i := 0; i < n; i++ {
		list = append(list, i)
	}
	newList := make([]int, 0)
	t := m
	for len(list) > 1 {
		t = m % len(list)
		if t == 0 {
			newList = list[:len(list)-1]
		} else {
			newList = list[t:]
			newList = append(newList, list[:t-1]...)
		}
		list = newList
		fmt.Print(list)
	}
	return list[0]
}
