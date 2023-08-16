package hot100

func productExceptSelf(nums []int) []int {
	arr := make([]int, len(nums))
	res := make([]int, len(nums))
	arr[len(arr)-1] = 1
	for i := len(nums) - 2; i >= 0; i-- {
		arr[i] = arr[i+1] * nums[i+1]
	}
	res[0] = arr[0]
	pre := 1
	for i := 1; i < len(nums); i++ {
		pre = pre * nums[i-1]
		res[i] = pre * arr[i]
	}
	return res
}
