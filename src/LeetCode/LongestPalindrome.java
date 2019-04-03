package LeetCode;

public class LongestPalindrome {
    /*
    https://leetcode.com/problems/longest-palindromic-substring/
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:
    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.

    Example 2:
    Input: "cbbd"
    Output: "bb"
     */

    public String longestPalindrome(String s) {
        for (int step = s.length(); step > 0 ; step--) {
            int left = 0;
            int right = left + step - 1;
            while (right < s.length()) {
                boolean flag = true;
                for (int i = 0; i < step / 2; i++) {
                    if (s.charAt(left + i) != s.charAt(right - i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return s.substring(left, right+1);
                left++;
                right++;
            }
        }
        return s.substring(0, 0);
    }

    public static void main(String[] args) {
        String a = "daaaaad";
        System.out.println(new LongestPalindrome().longestPalindrome(a));
    }
}
