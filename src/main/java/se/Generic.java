package se;

/**
 * @author jingxinwu
 * @date 2022-02-20 12:55 PM
 *         泛型类
 */
public class Generic<T> {
    //泛型的类型参数只能是类类型，不能是简单类型

    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey() { //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    //此处’？’是类型实参，而不是类型形参 。重要说三遍！此处’？’是类型实参，而不是类型形参 ！ 此处’？’是类型实参，而不是类型形参 ！
    // 再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，可以把？看成所有类型的父类。是一种真实的类型。
    public void showKeyValue1(Generic<?> obj) {
        System.out.println("泛型测试 key value is " + obj.getKey());
    }

    public <T> T genericMethod(Class<T> tClass) throws InstantiationException,
            IllegalAccessException {
        return tClass.newInstance();
    }

    Generic<Integer> genericInteger = new Generic<>(123456);

    //传入的实参类型需与泛型的类型参数类型相同，即为String.
    Generic<String> genericString = new Generic<>("key_vlaue");


}
