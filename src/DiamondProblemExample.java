interface InterfaceA {
    default void display() {
        System.out.println("InterfaceA display");
    }
}

interface InterfaceB extends InterfaceA {
    default void display() {
        System.out.println("InterfaceB display");
    }
}

interface InterfaceC extends InterfaceA {
    default void display() {
        System.out.println("InterfaceC display");
    }
}

// Class inheriting InterfaceB and InterfaceC, which both inherit InterfaceA
class MyClass implements InterfaceB, InterfaceC {
    // Resolving the diamond problem by providing its own implementation of display method
    @Override
    public void display() {
        InterfaceB.super.display(); // Resolving the ambiguity by explicitly calling the method from InterfaceB
        InterfaceC.super.display(); // Resolving the ambiguity by explicitly calling the method from InterfaceC
    }
}

public class DiamondProblemExample {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.display(); // Calling the overridden display method in MyClass
    }
}
