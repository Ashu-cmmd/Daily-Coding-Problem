import java.util.*;

public class _37_PowerSet {

    // Method to generate the power set using an array
    public static List<List<Integer>> generatePowerSet(int[] inputArray) {
        List<List<Integer>> powerSet = new ArrayList<>();
        
        // The total number of subsets is 2^n (where n is the number of elements)
        int numberOfSubsets = 1 << inputArray.length;  // 2^n
        
        // Iterate through all possible combinations of elements (from 0 to 2^n - 1)
        for (int i = 0; i < numberOfSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            
            // For each bit in the number, if the bit is set, include that element in the subset
            for (int j = 0; j < inputArray.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(inputArray[j]);
                }
            }
            powerSet.add(subset);
        }
        
        return powerSet;
    }

    public static void main(String[] args) {
        // Example array
        int[] inputArray = {1, 2, 3};
        
        // Generate the power set
        List<List<Integer>> powerSet = generatePowerSet(inputArray);
        
        // Print the power set
        System.out.println("Power set: " + powerSet);
    }
}
