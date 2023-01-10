package _023daily

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 17:59
 */

func areNumbersAscending(s string) bool {
	if len(s) == 0 {
		return true
	}
	list := make([]int, 0)

	index := 0
	for index < len(s) {
		if s[index] < '0' || s[index] > '9' {
			index++
		} else if s[index] >= '0' && s[index] <= '9' {
			sum := 0
			for index < len(s) && s[index] >= '0' && s[index] <= '9' {
				sum = sum*10 + int(s[index]-'0')
				index++
			}
			list = append(list, sum)
		}
	}
	for i := 0; i < len(list)-1; i++ {
		if list[i] >= list[i+1] {
			return false
		}
	}
	return true
}
