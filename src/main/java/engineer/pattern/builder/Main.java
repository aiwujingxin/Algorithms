package engineer.pattern.builder;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/9 01:05
 */
public class Main {

    public static void main(String[] args) {
        ComplexObject complexObject = new ComplexObjectBuilder()
                .setProperty1("value1")
                .setProperty2(42)
                .build();
        System.out.println(complexObject);
    }
}
