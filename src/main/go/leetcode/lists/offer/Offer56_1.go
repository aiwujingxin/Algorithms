package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/5 16:07
 */

// 异或分组
func singleNumbers(nums []int) []int {
	if len(nums) == 0 {
		return []int{}
	}
	flag := 0
	for i := 0; i < len(nums); i++ {
		flag = flag ^ nums[i]
	}
	div := 1
	//不为 0 的最低位
	for (div & flag) == 0 {
		div <<= 1
	}
	a, b := 0, 0
	for i := 0; i < len(nums); i++ {
		n := nums[i]
		if (div & nums[i]) != 0 {
			a ^= n
		} else {
			b ^= n
		}
	}
	return []int{a, b}
}
