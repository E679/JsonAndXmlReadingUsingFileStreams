package cloning;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Side-by-side comparison of Shallow vs Deep Cloning
 * This example clearly shows the difference in behavior
 */
public class ComparisonExample {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     SHALLOW CLONING vs DEEP CLONING COMPARISON             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        // Create two identical original persons
        Address address1 = new Address("456 Oak Ave", "Boston", "02101", "USA");
        ArrayList<String> hobbies1 = new ArrayList<>(Arrays.asList("Coding", "Gaming"));
        Person original1 = new Person("Alice", 28, address1, hobbies1);

        Address address2 = new Address("456 Oak Ave", "Boston", "02101", "USA");
        ArrayList<String> hobbies2 = new ArrayList<>(Arrays.asList("Coding", "Gaming"));
        Person original2 = new Person("Alice", 28, address2, hobbies2);

        System.out.println("Starting with two identical persons:\n");
        System.out.println("Person 1: " + original1);
        System.out.println("Person 2: " + original2);
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Create shallow and deep clones
        Person shallowClone = original1.shallowClone();
        Person deepClone = original2.deepClone();

        System.out.println("SHALLOW CLONE created from Person 1");
        System.out.println("DEEP CLONE created from Person 2");
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Modify both clones identically
        System.out.println("Now modifying BOTH clones in the same way:");
        System.out.println("  - Change name to 'Bob'");
        System.out.println("  - Change age to 35");
        System.out.println("  - Change city to 'Chicago'");
        System.out.println("  - Add 'Traveling' to hobbies");
        System.out.println();

        shallowClone.setName("Bob");
        shallowClone.setAge(35);
        shallowClone.getAddress().setCity("Chicago");
        shallowClone.getHobbies().add("Traveling");

        deepClone.setName("Bob");
        deepClone.setAge(35);
        deepClone.getAddress().setCity("Chicago");
        deepClone.getHobbies().add("Traveling");

        System.out.println("=".repeat(60));
        System.out.println("RESULTS AFTER MODIFICATION:");
        System.out.println("=".repeat(60) + "\n");

        // Show shallow cloning results
        System.out.println("┌─ SHALLOW CLONING ─────────────────────────────────────────┐");
        System.out.println("│ Original Person 1 (after modifying shallow clone):        │");
        System.out.println("│ " + original1);
        System.out.println("│                                                            │");
        System.out.println("│ Shallow Clone:                                             │");
        System.out.println("│ " + shallowClone);
        System.out.println("│                                                            │");
        System.out.println("│ ⚠️  PROBLEM: Original was affected!                        │");
        System.out.println("│    - City changed: " + original1.getAddress().getCity() + " (unintended!)");
        System.out.println("│    - Hobbies changed: " + original1.getHobbies().size() + " items (unintended!)");
        System.out.println("└────────────────────────────────────────────────────────────┘\n");

        // Show deep cloning results
        System.out.println("┌─ DEEP CLONING ────────────────────────────────────────────┐");
        System.out.println("│ Original Person 2 (after modifying deep clone):           │");
        System.out.println("│ " + original2);
        System.out.println("│                                                            │");
        System.out.println("│ Deep Clone:                                                │");
        System.out.println("│ " + deepClone);
        System.out.println("│                                                            │");
        System.out.println("│ ✓ SUCCESS: Original is unchanged!                          │");
        System.out.println("│    - City unchanged: " + original2.getAddress().getCity() + " (as expected!)");
        System.out.println("│    - Hobbies unchanged: " + original2.getHobbies().size() + " items (as expected!)");
        System.out.println("└────────────────────────────────────────────────────────────┘\n");

        // Summary
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                         SUMMARY                            ║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println("║ SHALLOW CLONING:                                           ║");
        System.out.println("║   • Fast and memory efficient                              ║");
        System.out.println("║   • Shares nested objects between original and clone       ║");
        System.out.println("║   • Changes to nested objects affect both                  ║");
        System.out.println("║   • Use when: You want to share nested objects             ║");
        System.out.println("║                                                            ║");
        System.out.println("║ DEEP CLONING:                                              ║");
        System.out.println("║   • Slower and uses more memory                            ║");
        System.out.println("║   • Creates independent copies of all nested objects       ║");
        System.out.println("║   • Changes to nested objects are isolated                 ║");
        System.out.println("║   • Use when: You need complete independence               ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}

