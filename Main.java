//First file in git
public class Main {
    public static void main(String[] args) {
        Child myObj = new Child();
        System.out.println(myObj.returnValue(1011));
    }
}

abstract class Parent {

    abstract int display(int i);

    int returnValue(int i) {
        return display(++i);
    }
}

class Child extends Parent {
    int display(int i) {
        return ++i;
    }
}

