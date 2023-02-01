package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 18:53
 */

func pivotIndex(nums []int) int {
	total := 0
	for _, v := range nums {
		total += v
	}
	sum := 0
	for i, v := range nums {
		if 2*sum+v == total {
			return i
		}
		sum += v
	}
	return -1
}
