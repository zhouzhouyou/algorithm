package LeetCode;

public class ReverseInteger {
    /*
        https://leetcode.com/problems/reverse-integer/
        Given a 32-bit signed integer, reverse digits of an integer.

        Example 1:
        Input: 123
        Output: 321

        Example 2:
        Input: -123
        Output: -321

        Example 3:
        Input: 120
        Output: 21

        Note:
        Assume we are dealing with an environment which could only store integers
        within the 32-bit signed integer range: [−231,  231 − 1].
        For the purpose of this problem,
        assume that your function returns 0 when the reversed integer overflows.
     */
    public int reverse(int x) {
        long out = 0;
        boolean flag = x < 0;
        if (flag) x = 0 - x;
        while (x > 0) {
            int mod = x % 10;
            out *= 10;
            out += mod;
            if (out > Integer.MAX_VALUE) return 0;
            if (out < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        out = (flag) ? 0 - out : out;
        return (int) out;
    }
}
