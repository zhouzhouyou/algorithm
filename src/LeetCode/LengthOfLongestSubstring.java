package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    /*
        https://leetcode.com/problems/longest-substring-without-repeating-characters/
        Given a string, find the length of the longest substring without repeating characters.

        Example 1:
        Input: "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

        Example 2:
        Input: "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.

        Example 3:
        Input: "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
     */

    public int lengthOfLongestSubstring(String s) {
        int max = 0, i = 0, j = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "abcadefga";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(a));
    }
}
