package LeetCode;

import java.util.Arrays;

public class ThreeSumClosest {
    /*
    https://leetcode.com/problems/3sum-closest/
     */

    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        for (int i = 0; i < length - 2; i++) {
            int base = nums[i];
            int lo = i + 1, hi = length-1;
            int cp = nums[lo] + nums[hi] + base - target;

            while (lo < hi) {
                int temp = nums[lo] + nums[hi] + base - target;
                if (temp == 0) return target;
                else {
                    if (temp < 0) while (lo < hi && nums[lo+1] == nums[lo]) lo++;
                    else while (lo < hi && nums[hi-1] == nums[hi]) hi--;
                    if (Math.abs(temp) < Math.abs(cp)) cp = temp;
                    if (temp < 0) lo++;
                    else hi--;
                }
            }
            if (Math.abs(cp) < Math.abs(closet)) closet = cp;

        }
        return closet + target;
    }

    public static void main(String[] args) {
        ThreeSumClosest closest = new ThreeSumClosest();
        //int[] test = {-1, 2, 1, -4};
        int[] test = {0, 0, 0};
        System.out.println(closest.threeSumClosest(test, 1));
    }
}
