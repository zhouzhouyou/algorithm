package LeetCode;

import java.util.*;

public class ThreeSum {
    /*
        https://leetcode.com/problems/3sum/
        Given an array nums of n integers,
        are there elements a, b, c in nums such that a + b + c = 0?
        Find all unique triplets in the array which gives the sum of zero.
     */


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i != 0 && num == nums[i-1]) continue;
            set.addAll(twoSum(nums, 0 - num, i));
        }
        return new ArrayList<>(set);
    }

    public HashSet<List<Integer>> twoSum(int[] nums, int target, int start) {
        HashSet<List<Integer>> set = new HashSet<>();
        int length = nums.length;
        for (int i = start+1; i < length; i++) {
            int num1 = nums[i];
            int newTarget = target - num1;
            if (find(nums, newTarget, i+1, length-1)) {
                List<Integer> list = new ArrayList<>();
                list.add(0 - target);
                list.add(num1);
                list.add(newTarget);
                set.add(list);
            }
        }
        return set;
    }

    public boolean find(int[] nums, int target, int low, int high) {
        int middle = low + (high - low) / 2;
        if (low > high) return false;
        int cmp = Integer.compare(target, nums[middle]);
        if (cmp == 0) return true;
        else if (cmp < 0) return find(nums, target, low, middle-1);
        else return find(nums, target, middle+1, high);
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new ThreeSum().threeSum(nums);
        for (List<Integer> x: lists) {
            System.out.println(x);
        }
    }
}
