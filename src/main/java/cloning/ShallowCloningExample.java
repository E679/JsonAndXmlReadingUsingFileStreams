package cloning;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Demonstrates SHALLOW CLONING behavior
 * 
 * SHALLOW CLONING:
 * - Creates a new object
 * - Copies all fields from the original
 * - For primitive types: copies the actual value
 * - For reference types: copies only the reference (memory address)
 * - Result: Original and clone share the same nested objects
 */
public class ShallowCloningExample {

    public static void main(String[] args) {
        System.out.println("=== SHALLOW CLONING DEMONSTRATION ===\n");

        // Create original person with address and hobbies
        Address originalAddress = new Address("123 Main St", "New York", "10001", "USA");
        ArrayList<String> originalHobbies = new ArrayList<>(Arrays.asList("Reading", "Swimming"));
        
        Person original = new Person("John Doe", 30, originalAddress, originalHobbies);

        System.out.println("ORIGINAL PERSON (before cloning):");
        System.out.println(original);
        System.out.println();

        // Perform SHALLOW CLONE
        Person shallowClone = original.shallowClone();

        System.out.println("SHALLOW CLONE (immediately after cloning):");
        System.out.println(shallowClone);
        System.out.println();

        // Check if they are different objects
        System.out.println("Are they different Person objects? " + (original != shallowClone));
        System.out.println("Are they sharing the same Address object? " + (original.getAddress() == shallowClone.getAddress()));
        System.out.println("Are they sharing the same Hobbies list? " + (original.getHobbies() == shallowClone.getHobbies()));
        System.out.println();

        System.out.println("--- Now let's modify the CLONE ---\n");

        // Modify primitive field in clone
        shallowClone.setName("Jane Smith");
        shallowClone.setAge(25);

        // Modify nested object (Address) through clone
        shallowClone.getAddress().setCity("Los Angeles");
        shallowClone.getAddress().setZipCode("90001");

        // Modify collection through clone
        shallowClone.getHobbies().add("Painting");

        System.out.println("ORIGINAL PERSON (after modifying clone):");
        System.out.println(original);
        System.out.println();

        System.out.println("SHALLOW CLONE (after modifications):");
        System.out.println(shallowClone);
        System.out.println();

        System.out.println("=== OBSERVATIONS ===");
        System.out.println("✓ Primitive fields (name, age): Changed only in clone");
        System.out.println("  - Original name: " + original.getName() + " (unchanged)");
        System.out.println("  - Clone name: " + shallowClone.getName() + " (changed)");
        System.out.println();
        
        System.out.println("✗ Reference fields (address, hobbies): Changed in BOTH!");
        System.out.println("  - Original city: " + original.getAddress().getCity() + " (CHANGED!)");
        System.out.println("  - Clone city: " + shallowClone.getAddress().getCity() + " (changed)");
        System.out.println("  - Original hobbies: " + original.getHobbies() + " (CHANGED!)");
        System.out.println("  - Clone hobbies: " + shallowClone.getHobbies() + " (changed)");
        System.out.println();
        
        System.out.println("WHY? Because shallow cloning only copies references,");
        System.out.println("not the actual objects. Both original and clone point to");
        System.out.println("the SAME Address and Hobbies objects in memory!");
    }
}

