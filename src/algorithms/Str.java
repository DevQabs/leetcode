package algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class Str {

    /**
     * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
     *
     * 1768. Merge Strings Alternately
     *
     * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
     * Return the merged string.
     *
     * Example 1:
     *
     * Input: word1 = "abc", word2 = "pqr"
     * Output: "apbqcr"
     * Explanation: The merged string will be merged as so:
     * word1:  a   b   c
     * word2:    p   q   r
     * merged: a p b q c r
     *
     *  Example 2:
     *
     * Input: word1 = "ab", word2 = "pqrs"
     * Output: "apbqrs"
     * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
     * word1:  a   b
     * word2:    p   q   r   s
     * merged: a p b q   r   s
     *
     * Example 3:
     *
     * Input: word1 = "abcd", word2 = "pq"
     * Output: "apbqcd"
     * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
     * word1:  a   b   c   d
     * word2:    p   q
     * merged: a p b q c   d
     *
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int count = Math.max(word1.length(), word2.length());
        for (int i = 0; i < count; i++) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }

    /**
     * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
     *
     * 1071. Greatest Common Divisor of Strings
     *
     * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
     * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
     *
     * Example 1:
     *
     * Input: str1 = "ABCABC", str2 = "ABC"
     * Output: "ABC"
     *
     * Example 2:
     *
     * Input: str1 = "ABABAB", str2 = "ABAB"
     * Output: "AB"
     *
     * Example 3:
     *
     * Input: str1 = "LEET", str2 = "CODE"
     * Output: ""
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder(str1.length() > str2.length() ? str2 : str1);
        int count = Math.min(str1.length(), str2.length());
        for (int i = count - 1; i >= 0; i--) {
            if (str1.replace(sb.toString(), "").isEmpty() && str2.replace(sb.toString(), "").isEmpty()) {
                return sb.toString();
            }

            if (i == count -1) i = i / 2;
            sb.deleteCharAt(i);
        }

        return "";
    }

    /**
     * https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
     *
     * 345. Reverse Vowels of a String
     *
     * Given a string s, reverse only all the vowels in the string and return it.
     * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
     *
     * Example 1:
     *
     * Input: s = "hello"
     * Output: "holle"
     *
     * Example 2:
     *
     * Input: s = "leetcode"
     * Output: "leotcede"
     *
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if ("aeiouAEIOU".contains(sb.substring(i, i + 1))) {
                stack.push(sb.charAt(i));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if ("aeiouAEIOU".contains(sb.substring(i, i + 1))) {
                sb.setCharAt(i, stack.pop());
            }
        }

        return sb.toString();
    }

    private String reverseVowelsAnsewer(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = s.length() - 1;

        while (right > left) {
            if (!set.contains(sb.charAt(left))) {
                left++;
            }

            if (!set.contains(sb.charAt(right))) {
                right--;
            }

            if  (set.contains(sb.charAt(left)) && set.contains(sb.charAt(right))) {
                char temp = sb.charAt(left);
                sb.setCharAt(left++, sb.charAt(right));
                sb.setCharAt(right--, temp);
            }
        }

        return null;
    }

    /**
     * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
     *
     * 151. Reverse Words in a String
     *
     * Given an input string s, reverse the order of the words.
     * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     * Return a string of the words in reverse order concatenated by a single space.
     * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
     *
     * Example 1:
     *
     * Input: s = "the sky is blue"
     * Output: "blue is sky the"
     *
     * Example 2:
     *
     * Input: s = "  hello world  "
     * Output: "world hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     *
     * Example 3:
     *
     * Input: s = "a good   example"
     * Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     *
     */
    public String reverseWords(String s) {
        return "";
    }
}