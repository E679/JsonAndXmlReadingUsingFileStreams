package JSONFileReading;

public class MyClass {
    private String name;
    private int value;
    // No-argument constructor
    public MyClass() {
    }
    // Parameterized constructor
    public MyClass(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
    @Override
    public String toString() {
        return "MyClass{name='" + name + "', value=" + value + "}";
    }
}
