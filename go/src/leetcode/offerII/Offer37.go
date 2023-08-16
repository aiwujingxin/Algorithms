package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/15 20:52
 */

//[-2,-2,1,-2]
//[-2,-2,1,-1]

func asteroidCollision(asteroids []int) []int {
	if len(asteroids) == 0 {
		return []int{}
	}
	stack := make([]int, 0)
	stack = append(stack, asteroids[0])
	for i := 1; i < len(asteroids); i++ {
		// 碰撞
		if len(stack) > 0 && asteroids[i] < 0 && stack[len(stack)-1] > 0 {
			var last = stack[len(stack)-1]
			var remove int
			// 大于等于的时候，都给撞了
			for len(stack) > 0 && Abs(asteroids[i]) >= last && last > 0 {
				//大于的时候
				if Abs(asteroids[i]) > last {
					remove = stack[len(stack)-1]
					stack = stack[:len(stack)-1]
					if len(stack) > 0 {
						last = stack[len(stack)-1]
					} else {
						break
					}
				}
				//等于的时候
				if Abs(asteroids[i]) == last {
					remove = stack[len(stack)-1]
					stack = stack[:len(stack)-1]
					break
				}
			}
			// 处理相等情况
			if Abs(asteroids[i]) == remove {
				continue
			}
			if len(stack) == 0 || len(stack) > 0 && stack[len(stack)-1] < 0 {
				stack = append(stack, asteroids[i])
			}
		} else {
			stack = append(stack, asteroids[i])
		}
	}
	return stack
}

func asteroidCollisionV2(asteroids []int) []int {
	if len(asteroids) == 0 {
		return []int{}
	}
	stack := make([]int, 0)
	for i := 0; i < len(asteroids); i++ {
		as := asteroids[i]
		for len(stack) > 0 && -as > stack[len(stack)-1] && stack[len(stack)-1] > 0 {
			// 碰撞，大于 栈顶消失
			stack = stack[:len(stack)-1]
		}
		if len(stack) != 0 && as < 0 && stack[len(stack)-1] == -as {
			// 碰撞，等于 栈顶消失
			stack = stack[:len(stack)-1]
		} else if len(stack) == 0 || as > 0 || len(stack) > 0 && stack[len(stack)-1] < 0 {
			stack = append(stack, as)
		}
	}
	return stack
}
