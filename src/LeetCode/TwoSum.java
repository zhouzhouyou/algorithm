package LeetCode;
import java.util.HashMap;

public class TwoSum {
    /*
        https://leetcode.com/problems/two-sum/
        Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:
        Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] solution = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int cp = target-nums[i];
            if (map.containsKey(cp)) {
                solution[0] = map.get(cp);
                solution[1] = i;
                return solution;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 9, 10, 9, 20};
        int[] answer;
        TwoSum twoSum = new TwoSum();
        answer = twoSum.twoSum(nums, 11);
        for (int x: answer) System.out.println(x);
    }
}
