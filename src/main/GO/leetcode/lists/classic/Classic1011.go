package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/14 17:11
 */

func wiggleSort(nums []int) {

	if len(nums) == 0 {
		return
	}

	for i := 0; i < len(nums)-1; i++ {
		if i%2 == 0 {
			if nums[i] > nums[i+1] {
				nums[i], nums[i+1] = nums[i+1], nums[i]
			}
		} else {
			if nums[i] < nums[i+1] {
				nums[i], nums[i+1] = nums[i+1], nums[i]
			}
		}
	}
}
