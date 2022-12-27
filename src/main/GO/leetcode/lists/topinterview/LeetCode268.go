package topinterview

func missingNumber(nums []int) int {
	n := len(nums)
	flag := n
	for i := 0; i < n; i++ {
		flag = flag ^ i ^ nums[i]
	}
	return flag
}
