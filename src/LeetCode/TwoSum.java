package LeetCode;
import java.util.HashMap;

public class TwoSum {
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
