package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/21 21:29
 */

func exchangeBits(num int) int {

	if num == 0 {
		return 0
	}
	arr := make([]int, 32)
	for i := 31; i >= 0; i-- {
		arr[i] = num & 1
		num = num >> 1
	}

	for i := 0; i < len(arr)-1; i = i + 2 {
		arr[i], arr[i+1] = arr[i+1], arr[i]
	}
	n := 0
	t := 0
	for i := 31; i >= 0; i-- {
		n = n + t*arr[i]
		t = t * 2
	}
	return n
}
