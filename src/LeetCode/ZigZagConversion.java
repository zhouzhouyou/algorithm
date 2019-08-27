package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    /*
    https://leetcode.com/problems/zigzag-conversion/
     */

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goDown = false;

        for (Character c : s.toCharArray()) {
            list.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows - 1) goDown = !goDown;
            currentRow += goDown ? 1 : -1;
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            builder.append(stringBuilder.toString());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING", 3));
    }


}
