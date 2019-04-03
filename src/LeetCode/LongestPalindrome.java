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
        StringBuilder temp = new StringBuilder("~|");
        for (int i = 0; i < s.length(); i++) {
            temp.append(s.charAt(i));
            temp.append("|");
        }
        String str = temp.toString();
        int[] array = new int[str.length()];
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            array[i] = getLength(str, i);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[max]) max = i;
        }
        int left = (max-array[max]) / 2;
        int right = left + array[max] -1 ;
        return s.substring(left, right);
    }

    int getLength(String s, int location) {
        int n = s.length();
        int ans = 1;
        if (location == 0 || location == n-1) return 1;
        int i = location-1, j = location+1;
        while (i >= 0 && j < n) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
                ans++;
            } else {
                return ans;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        String a = "12321";
        System.out.println(new LongestPalindrome().longestPalindrome(a));
    }
}
