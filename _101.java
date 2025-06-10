/**
 * Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.
 * A solution will always exist. See Goldbach’s conjecture.
 *
 * Example:
 *
 * Input: 4
 * Output: 2 + 2 = 4
 * If there are more than one solution possible, return the lexicographically smaller solution.
 *
 * If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, then
 *
 * [a, b] < [c, d]
 * If a < c OR a==c AND b < d.
 *
 * @param A The even number
 * @return An array of two prime numbers whose sum is equal to the given number.
 */
import java.util.ArrayList;
import java.util.Arrays;

class _101_Solution {
    public ArrayList<Integer> primesum(int A) {
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= A; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= A; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= A / 2; i++) {
            if (isPrime[i] && isPrime[A - i]) {
                result.add(i);
                result.add(A - i);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        _101_Solution solution = new _101_Solution();
        int input = 4;
        ArrayList<Integer> result = solution.primesum(input);
        System.out.println(result.get(0) + " + " + result.get(1) + " = " + input);

        input = 6;
        result = solution.primesum(input);
        System.out.println(result.get(0) + " + " + result.get(1) + " = " + input);

        input = 8;
        result = solution.primesum(input);
        System.out.println(result.get(0) + " + " + result.get(1) + " = " + input);

        input = 10;
        result = solution.primesum(input);
        System.out.println(result.get(0) + " + " + result.get(1) + " = " + input);
    }
}
