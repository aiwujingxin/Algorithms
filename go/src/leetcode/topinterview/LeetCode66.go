package topinterview

func plusOne(digits []int) []int {

	if len(digits) == 0 {
		return []int{}
	}

	flag := 0
	for i := len(digits) - 1; i >= 0; i-- {
		temp := digits[i] + flag
		if i == len(digits)-1 {
			temp += 1
		}
		digits[i] = temp % 10
		flag = temp / 10
	}
	if flag == 1 {
		list := []int{1}
		list = append(list, digits...)
		return list
	}
	return digits
}
