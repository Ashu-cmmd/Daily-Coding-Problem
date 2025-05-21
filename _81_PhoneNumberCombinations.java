// Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent. You can assume each valid number in the mapping is a single digit.

// For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _81_PhoneNumberCombinations {
    // Mapping of digits to letters
    private static final Map<Character, String> digitToLettersMap = new HashMap<>();

    static {
        digitToLettersMap.put('2', "abc");
        digitToLettersMap.put('3', "def");
        digitToLettersMap.put('4', "ghi");
        digitToLettersMap.put('5', "jkl");
        digitToLettersMap.put('6', "mno");
        digitToLettersMap.put('7', "pqrs");
        digitToLettersMap.put('8', "tuv");
        digitToLettersMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        // If the combination is the same length as digits, we found a valid combination
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        // Get the letters that the current digit maps to
        char digit = digits.charAt(index);
        String letters = digitToLettersMap.get(digit);

        // Loop through the letters and build combinations
        for (char letter : letters.toCharArray()) {
            combination.append(letter); // Add the letter to the combination
            backtrack(result, combination, digits, index + 1); // Move to the next digit
            combination.deleteCharAt(combination.length() - 1); // Remove the last letter for backtracking
        }
    }

    public static void main(String[] args) {
        _81_PhoneNumberCombinations phoneNumberCombinations = new _81_PhoneNumberCombinations();
        String digits = "23";
        List<String> combinations = phoneNumberCombinations.letterCombinations(digits);
        System.out.println(combinations);
    }
}
