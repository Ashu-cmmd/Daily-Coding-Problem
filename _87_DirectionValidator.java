// A rule looks like this:

// A NE B

// This means this means point A is located northeast of point B.

// A SW C

// means that point A is southwest of C.

// Given a list of rules, check if the sum of the rules validate. For example:

// A N B
// B NE C
// C N A
// does not validate, since A cannot be both north and south of C.

// A NW B
// A N B
// is considered valid.
import java.util.HashMap;
import java.util.Map;

public class _87_DirectionValidator {

    // Define direction vectors
    private static final Map<String, int[]> directionVectors = new HashMap<>();

    static {
        directionVectors.put("N", new int[]{0, 1});
        directionVectors.put("NE", new int[]{1, 1});
        directionVectors.put("E", new int[]{1, 0});
        directionVectors.put("SE", new int[]{1, -1});
        directionVectors.put("S", new int[]{0, -1});
        directionVectors.put("SW", new int[]{-1, -1});
        directionVectors.put("W", new int[]{-1, 0});
        directionVectors.put("NW", new int[]{-1, 1});
    }

    public static boolean validateRules(String[] rules) {
        Map<String, int[]> positions = new HashMap<>();

        for (String rule : rules) {
            String[] parts = rule.split(" ");
            String pointA = parts[0];
            String direction = parts[1];
            String pointB = parts[2];

            // Get the vector for the direction
            int[] vector = directionVectors.get(direction);
            if (vector == null) {
                throw new IllegalArgumentException("Invalid direction: " + direction);
            }

            // Update the position of point A based on point B's position
            int[] positionB = positions.getOrDefault(pointB, new int[]{0, 0});
            int[] newPositionA = new int[]{positionB[0] + vector[0], positionB[1] + vector[1]};

            // Check for contradictions
            if (positions.containsKey(pointA)) {
                int[] currentPositionA = positions.get(pointA);
                if (currentPositionA[0] != newPositionA[0] || currentPositionA[1] != newPositionA[1]) {
                    return false; // Contradiction found
                }
            }

            // Update the position of point A
            positions.put(pointA, newPositionA);
        }

        return true; // No contradictions found
    }

    public static void main(String[] args) {
        String[] rules1 = {"A N B", "B NE C", "C N A"};
        String[] rules2 = {"A NW B", "A N B"};

        System.out.println("Rules 1 valid: " + validateRules(rules1)); // Should print false
        System.out.println("Rules 2 valid: " + validateRules(rules2)); // Should print true
    }
}
