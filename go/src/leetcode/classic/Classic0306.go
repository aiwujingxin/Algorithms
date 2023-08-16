package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/2 18:22
 */

type AnimalShelf struct {
	dogs []int
	cats []int
}

func ConstructorAnimalShelf() AnimalShelf {
	return AnimalShelf{}
}

func (this *AnimalShelf) Enqueue(animal []int) {
	switch animal[1] {
	case 0:
		this.cats = append(this.cats, animal[0])
	case 1:
		this.dogs = append(this.dogs, animal[0])
	}
}

func (this *AnimalShelf) DequeueAny() []int {
	if len(this.cats) == 0 && len(this.dogs) == 0 {
		return []int{-1, -1}
	}

	if len(this.cats) != 0 && len(this.dogs) != 0 {
		if this.cats[0] < this.dogs[0] {
			res := this.cats[0]
			this.cats = this.cats[1:]
			return []int{res, 0}
		} else {
			res := this.dogs[0]
			this.dogs = this.dogs[1:]
			return []int{res, 1}
		}
	}

	if len(this.dogs) == 0 {
		res := this.cats[0]
		this.cats = this.cats[1:]
		return []int{res, 0}
	} else {
		res := this.dogs[0]
		this.dogs = this.dogs[1:]
		return []int{res, 1}
	}
}

func (this *AnimalShelf) DequeueDog() []int {
	if len(this.dogs) == 0 {
		return []int{-1, -1}
	}

	res := this.dogs[0]
	this.dogs = this.dogs[1:]
	return []int{res, 1}
}

func (this *AnimalShelf) DequeueCat() []int {
	if len(this.cats) == 0 {
		return []int{-1, -1}
	}

	res := this.cats[0]
	this.cats = this.cats[1:]
	return []int{res, 0}
}
