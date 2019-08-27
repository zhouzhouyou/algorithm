package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger to = new StringToInteger();
        System.out.println(to.myAtoi("2147483648"));
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        char leading = str.charAt(0);
        boolean flag = true;
        if (leading >= '0' && leading <= '9') flag = false;
        if (leading == '-' || leading == '+') {
            if (str.length() == 1) return 0;
            char second = str.charAt(1);
            if (second >= '0' && second <= '9') flag = false;
        }
        if (flag) return 0;

        List<Character> list  = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') list.add(c);
            else {
                if (c == '-' || c == '+') list.add(c);
            }
        }

        String max = String.valueOf(Integer.MAX_VALUE);
        String min = String.valueOf(Integer.MIN_VALUE);
        String out = "";
        for (char c : list) out += c;
        if (list.get(0) == '-') {
            if (out.compareTo(min) > 0) return Integer.MIN_VALUE;
            if (out.length() > min.length()) return Integer.MIN_VALUE;
        } else {
            if (out.compareTo(max) > 0) return Integer.MAX_VALUE;
            if (out.length() > max.length()) return Integer.MAX_VALUE;
        }
        return Integer.valueOf(out);

    }
}
