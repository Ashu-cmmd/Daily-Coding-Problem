public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        
        for (int num : nums) {
            // twos will hold the bits that appear twice
            twos |= ones & num;
            
            // ones will hold the bits that appear once
            ones ^= num;
            
            // threes will hold the bits that appear three times
            threes = ones & twos;
            
            // Remove the bits that appeared three times from ones and twos
            ones &= ~threes;
            twos &= ~threes;
        }
        
        return ones;
    }
    
    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        
        int[] nums1 = {6, 1, 3, 3, 3, 6, 6};
        System.out.println(solution.singleNumber(nums1));  // Output: 1
        
        int[] nums2 = {13, 19, 13, 13};
        System.out.println(solution.singleNumber(nums2));  // Output: 19
    }
}
