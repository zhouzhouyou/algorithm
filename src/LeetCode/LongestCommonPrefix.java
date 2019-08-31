package LeetCode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String base = strs[0];
        while (base.length() > 0) {
            boolean flag = true;
            for (String str : strs) {
                if (str.indexOf(base) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) return base;
            base = base.substring(0, base.length()-1);
        }
        return "";
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String[] test = {"c","acc","ccc"};
        System.out.println(prefix.longestCommonPrefix(test));
    }
}
