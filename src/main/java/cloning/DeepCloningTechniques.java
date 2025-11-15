package cloning;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Demonstrates different techniques for Deep Cloning in Java
 * 
 * 1. Manual Deep Clone (implemented in Person class)
 * 2. Serialization-based Deep Clone
 * 3. JSON-based Deep Clone (using Gson)
 */
public class DeepCloningTechniques {

    public static void main(String[] args) {
        System.out.println("=== DIFFERENT DEEP CLONING TECHNIQUES ===\n");

        // Create original person
        Address originalAddress = new Address("789 Pine St", "Seattle", "98101", "USA");
        ArrayList<String> originalHobbies = new ArrayList<>(Arrays.asList("Hiking", "Photography"));
        Person original = new Person("Charlie", 32, originalAddress, originalHobbies);

        System.out.println("ORIGINAL PERSON:");
        System.out.println(original);
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Technique 1: Manual Deep Clone
        System.out.println("TECHNIQUE 1: Manual Deep Clone");
        System.out.println("- Manually clone each nested object");
        System.out.println("- Most control and best performance");
        System.out.println("- Requires implementing clone logic for each class");
        
        Person manualClone = original.deepClone();
        manualClone.getAddress().setCity("Portland");
        
        System.out.println("\nOriginal city: " + original.getAddress().getCity());
        System.out.println("Clone city: " + manualClone.getAddress().getCity());
        System.out.println("✓ Independent: " + !original.getAddress().getCity().equals(manualClone.getAddress().getCity()));
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Technique 2: Serialization-based Deep Clone
        System.out.println("TECHNIQUE 2: Serialization-based Deep Clone");
        System.out.println("- Serialize object to bytes, then deserialize");
        System.out.println("- Automatic deep copy of entire object graph");
        System.out.println("- Requires all classes to implement Serializable");
        System.out.println("- Note: Person class needs to implement Serializable for this");
        System.out.println("  (Not implemented in this example)");
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Technique 3: JSON-based Deep Clone
        System.out.println("TECHNIQUE 3: JSON-based Deep Clone");
        System.out.println("- Convert object to JSON, then back to object");
        System.out.println("- Works without Serializable interface");
        System.out.println("- Slower but very flexible");
        System.out.println("- Requires external library like Gson or Jackson");
        System.out.println("  (Example code available but commented out)");
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Summary
        System.out.println("COMPARISON OF TECHNIQUES:\n");
        System.out.println("┌────────────────┬──────────────┬──────────────┬─────────────┐");
        System.out.println("│ Technique      │ Performance  │ Flexibility  │ Complexity  │");
        System.out.println("├────────────────┼──────────────┼──────────────┼─────────────┤");
        System.out.println("│ Manual Clone   │ ⭐⭐⭐⭐⭐    │ ⭐⭐⭐        │ ⭐⭐⭐⭐      │");
        System.out.println("│ Serialization  │ ⭐⭐⭐        │ ⭐⭐⭐⭐      │ ⭐⭐          │");
        System.out.println("│ JSON-based     │ ⭐⭐          │ ⭐⭐⭐⭐⭐    │ ⭐            │");
        System.out.println("└────────────────┴──────────────┴──────────────┴─────────────┘");
        System.out.println("\nRECOMMENDATION:");
        System.out.println("• Use Manual Clone for performance-critical code");
        System.out.println("• Use JSON-based for complex object graphs");
        System.out.println("• Use Serialization for legacy code with Serializable");
    }

    /**
     * Deep clone using JSON serialization/deserialization
     * This technique converts the object to JSON and back
     *
     * EXAMPLE (requires Gson library):
     *
     * import com.google.gson.Gson;
     *
     * private static Person deepCloneUsingJson(Person original) {
     *     try {
     *         Gson gson = new Gson();
     *         String json = gson.toJson(original);
     *         return gson.fromJson(json, Person.class);
     *     } catch (Exception e) {
     *         System.err.println("JSON cloning failed: " + e.getMessage());
     *         return null;
     *     }
     * }
     */

    /**
     * Deep clone using Java Serialization
     * Note: All classes must implement Serializable
     */
    @SuppressWarnings("unchecked")
    private static <T extends Serializable> T deepCloneUsingSerialization(T original) {
        try {
            // Serialize to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(original);
            oos.close();

            // Deserialize from byte array
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (Exception e) {
            System.err.println("Serialization cloning failed: " + e.getMessage());
            return null;
        }
    }
}

