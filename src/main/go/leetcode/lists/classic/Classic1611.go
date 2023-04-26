package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/3 16:02
 */

func divingBoard(shorter int, longer int, k int) []int {
	if k == 0 {
		return []int{}
	}
	if shorter == longer {
		return []int{shorter * k}
	}
	lengths := make([]int, k+1)
	for i := 0; i <= k; i++ {
		lengths[i] = shorter*(k-i) + longer*i
	}
	return lengths
}
