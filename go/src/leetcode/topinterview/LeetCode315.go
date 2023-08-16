package topinterview

func countSmaller(nums []int) []int {
	arr := make([]int, len(nums))
	index := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		index[i] = i
	}
	temp := make([]int, len(nums))
	tempIndex := make([]int, len(nums))
	countSmallerHelper(nums, 0, len(nums)-1, arr, index, temp, tempIndex)
	return arr
}

func countSmallerHelper(nums []int, l, r int, arr, index, temp, tempIndex []int) {
	if l >= r {
		return
	}
	mid := (l + r) / 2
	countSmallerHelper(nums, l, mid, arr, index, temp, tempIndex)
	countSmallerHelper(nums, mid+1, r, arr, index, temp, tempIndex)
	countSmallerMerge(nums, l, mid, r, arr, index, temp, tempIndex)
}

func countSmallerMerge(nums []int, l, m, r int, arr, index, temp, tempIndex []int) {
	//list1 i,mid
	//list2 mid+1,j
	k := l
	i, j := l, m+1
	for i <= m && j <= r {
		if nums[i] <= nums[j] {
			temp[k] = nums[i]
			// 下标 以及 贡献度
			tempIndex[k] = index[i]
			arr[index[i]] += j - m - 1
			i++
		} else {
			temp[k] = nums[j]
			tempIndex[k] = index[j]
			j++
		}
		k++
	}
	for i <= m {
		temp[k] = nums[i]
		// 下标 以及 贡献度
		tempIndex[k] = index[i]
		arr[index[i]] += j - m - 1
		i++
		k++
	}
	for j <= r {
		temp[k] = nums[j]
		tempIndex[k] = index[j]
		j++
		k++
	}
	for k := l; k <= r; k++ {
		nums[k] = temp[k]
		index[k] = tempIndex[k]
	}
}
