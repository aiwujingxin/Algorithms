package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/11 17:30
 */

func singleNumber(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	counts := make([]int, 32)
	for i := 0; i < len(nums); i++ {
		num := nums[i]
		for j := 0; j < 32; j++ {
			counts[j] += num & 1
			num >>= 1
		}
	}
	//注意溢出
	var res int32
	m := 3
	for i := 0; i < 32; i++ {
		res <<= 1
		res |= int32(counts[31-i] % m)
	}
	return int(res)
}
