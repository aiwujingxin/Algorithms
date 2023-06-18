package engineer.pattern.builder;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/9 01:05
 */
public class ComplexObjectBuilder {
    private String property1;
    private int property2;

    public ComplexObjectBuilder setProperty1(String property1) {
        this.property1 = property1;
        return this;
    }

    public ComplexObjectBuilder setProperty2(int property2) {
        this.property2 = property2;
        return this;
    }

    public ComplexObject build() {
        return new ComplexObject(property1, property2);
    }
}
