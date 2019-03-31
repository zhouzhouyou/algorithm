package LeetCode;

public class ReverseInteger {
//    Given a 32-bit signed integer, reverse digits of an integer.
//
//            Example 1:
//
//    Input: 123
//    Output: 321
//    Example 2:
//
//    Input: -123
//    Output: -321
//    Example 3:
//
//    Input: 120
//    Output: 21
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
