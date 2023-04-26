package topinterview

func calculate(s string) int {
	if len(s) == 0 {
		return 0
	}
	stack := make([]int, 0)
	sign := '+'
	num := 0
	for i := 0; i < len(s); i++ {
		ch := s[i]
		if IsNumber(ch) {
			num = num*10 + int(ch-'0')
		}
		if !IsNumber(ch) && s[i] != ' ' || i == len(s)-1 {
			switch sign {
			case '+':
				stack = append(stack, num)
				break
			case '-':
				stack = append(stack, -num)
				break
			case '*':
				last := stack[len(stack)-1]
				stack = stack[:len(stack)-1]
				stack = append(stack, last*num)
				break
			case '/':
				last := stack[len(stack)-1]
				stack = stack[:len(stack)-1]
				stack = append(stack, last/num)
				break
			}
			sign = int32(s[i])
			num = 0
		}
	}
	ans := 0
	//意思是最后算加减法, 并且减法转换成加法运算
	for len(stack) > 0 {
		num := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		ans += num
	}
	return ans
}
