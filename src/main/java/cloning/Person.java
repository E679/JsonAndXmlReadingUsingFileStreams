package cloning;

import java.util.ArrayList;
import java.util.List;

/**
 * Person class - demonstrates shallow vs deep cloning
 * Contains both primitive types and reference types (nested objects)
 */
public class Person implements Cloneable {
    // Primitive type - always copied by value
    private String name;
    private int age;
    
    // Reference type - this is where shallow vs deep cloning matters
    private Address address;
    
    // Collection - another reference type
    private List<String> hobbies;

    public Person(String name, int age, Address address, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobbies = hobbies;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * SHALLOW CLONE - Uses Object.clone() which creates a shallow copy
     * - Primitive fields (name, age) are copied by value
     * - Reference fields (address, hobbies) are copied by reference
     * - Changes to nested objects affect both original and clone
     */
    public Person shallowClone() {
        try {
            // super.clone() performs a shallow copy
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    /**
     * DEEP CLONE - Manually creates copies of all nested objects
     * - Primitive fields are copied by value
     * - Reference fields are recursively cloned
     * - Changes to nested objects do NOT affect the original
     */
    public Person deepClone() {
        try {
            // First perform shallow clone
            Person cloned = (Person) super.clone();
            
            // Then manually clone all reference types
            if (this.address != null) {
                cloned.address = this.address.clone();
            }
            
            if (this.hobbies != null) {
                cloned.hobbies = new ArrayList<>(this.hobbies);
            }
            
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", hobbies=" + hobbies +
                '}';
    }
}

