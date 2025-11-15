package cloning;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Demonstrates DEEP CLONING behavior
 * 
 * DEEP CLONING:
 * - Creates a new object
 * - Copies all fields from the original
 * - For primitive types: copies the actual value
 * - For reference types: creates NEW copies of the objects (recursively)
 * - Result: Original and clone are completely independent
 */
public class DeepCloningExample {

    public static void main(String[] args) {
        System.out.println("=== DEEP CLONING DEMONSTRATION ===\n");

        // Create original person with address and hobbies
        Address originalAddress = new Address("123 Main St", "New York", "10001", "USA");
        ArrayList<String> originalHobbies = new ArrayList<>(Arrays.asList("Reading", "Swimming"));
        
        Person original = new Person("John Doe", 30, originalAddress, originalHobbies);

        System.out.println("ORIGINAL PERSON (before cloning):");
        System.out.println(original);
        System.out.println();

        // Perform DEEP CLONE
        Person deepClone = original.deepClone();

        System.out.println("DEEP CLONE (immediately after cloning):");
        System.out.println(deepClone);
        System.out.println();

        // Check if they are different objects
        System.out.println("Are they different Person objects? " + (original != deepClone));
        System.out.println("Are they sharing the same Address object? " + (original.getAddress() == deepClone.getAddress()));
        System.out.println("Are they sharing the same Hobbies list? " + (original.getHobbies() == deepClone.getHobbies()));
        System.out.println();

        System.out.println("--- Now let's modify the CLONE ---\n");

        // Modify primitive field in clone
        deepClone.setName("Jane Smith");
        deepClone.setAge(25);

        // Modify nested object (Address) through clone
        deepClone.getAddress().setCity("Los Angeles");
        deepClone.getAddress().setZipCode("90001");

        // Modify collection through clone
        deepClone.getHobbies().add("Painting");

        System.out.println("ORIGINAL PERSON (after modifying clone):");
        System.out.println(original);
        System.out.println();

        System.out.println("DEEP CLONE (after modifications):");
        System.out.println(deepClone);
        System.out.println();

        System.out.println("=== OBSERVATIONS ===");
        System.out.println("✓ Primitive fields (name, age): Changed only in clone");
        System.out.println("  - Original name: " + original.getName() + " (unchanged)");
        System.out.println("  - Clone name: " + deepClone.getName() + " (changed)");
        System.out.println();
        
        System.out.println("✓ Reference fields (address, hobbies): Changed only in clone!");
        System.out.println("  - Original city: " + original.getAddress().getCity() + " (UNCHANGED!)");
        System.out.println("  - Clone city: " + deepClone.getAddress().getCity() + " (changed)");
        System.out.println("  - Original hobbies: " + original.getHobbies() + " (UNCHANGED!)");
        System.out.println("  - Clone hobbies: " + deepClone.getHobbies() + " (changed)");
        System.out.println();
        
        System.out.println("WHY? Because deep cloning creates NEW copies of all nested");
        System.out.println("objects. Original and clone have completely separate Address");
        System.out.println("and Hobbies objects in memory. They are fully independent!");
    }
}

