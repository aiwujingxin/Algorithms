package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/12 16:49
 */

func Max(i, j int) int {
	if i > j {
		return i
	}
	return j
}

func Min(i, j int) int {
	if i < j {
		return i
	}
	return j
}

func Abs(i int) int {
	if i < 0 {
		return -i
	}
	return i
}
