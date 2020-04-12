package jlearn.variables;

class DefaultVariableTest {
    int a;

    public DefaultVariableTest (int a) {
        this.a = a;
    }
}

public class VariablesSample {
    public static void main (String[] args) {
        DefaultVariableTest d = new DefaultVariableTest(10);
        System.out.println(d.a);
    }
}