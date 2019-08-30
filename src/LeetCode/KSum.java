package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {
    /*
    这不是一个LeetCode的题目，目的是给出一个数组中，没有重复的，k个数之和为target的所有可能
     */

    List<List<Integer>> kSum(int[] nums, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < k || k < 2) return result;
        Arrays.sort(nums);
        kSum(nums, target, k, 0, result, new ArrayList<>());
        return result;
    }

    void kSum(int[] nums, int target, int k, int start, List<List<Integer>> result, List<Integer>path) {
        int end = nums.length - 1;
        int max = nums[end];
        if (nums[start] * k > target || max * k < target) return;
        if (k == 2) { //2sum
            int left = start;
            int right = end;
            while (left < right) {
                int cp = nums[left] + nums[right] - target;
                if (cp < 0) {
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                } else if (cp > 0) {
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                } else {
                    result.add(new ArrayList<>(path));
                    result.get(result.size()-1).addAll(Arrays.asList(nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;right--;
                }
            }
        } else { //ksun
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i-1]) continue;
                if (nums[i] + max * (k-1) < target) continue;
                if (nums[i] * k > target) break;
                if (nums[i] * k == target) {
                    if (nums[i + k - 1] == nums[i]) {
                        result.add(new ArrayList<>(path));
                        List<Integer> temp = new ArrayList<>();
                        for (int x = 0; x < k; x++) temp.add(nums[i]);
                        result.get(result.size() - 1).addAll(temp);
                    }
                    break;
                }
                path.add(nums[i]);
                kSum(nums, target - nums[i], k - 1, i + 1, result, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        KSum kSum = new KSum();
        int[] nums = {0,-1,-3,5,-5};
        System.out.println(kSum.kSum(nums, 1, 4));
    }
}
