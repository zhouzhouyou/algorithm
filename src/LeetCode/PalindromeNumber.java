package LeetCode;

public class PalindromeNumber {
    /*
    https://leetcode.com/problems/palindrome-number/
    感觉又是个屑题目，不把integer转字符串，但实际上原理估计还是转了
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int length = (int)Math.log10(x);
        int[] digit = new int[length+1];
        for (; length >= 0; length--) {
            int base = (int) (Math.pow(10, length));
            digit[length] = x/base;
            x -= digit[length] * base;
        }
        int low = 0, high = digit.length - 1;
        while (low < high) {
            if (digit[low] != digit[high]) return false;
            low++;high--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(11));
    }
}
