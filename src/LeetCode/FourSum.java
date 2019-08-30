package LeetCode;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length == 4) {
            int sum = 0;
            for (int num : nums) sum += num;
            if (sum == target) {
                List<Integer> resultList = new ArrayList<>(4);
                for (int num : nums) resultList.add(num);
                ans.add(resultList);
                return ans;
            }
        }
        for (int i = 0; i < nums.length - 3; i++) {
            int base = nums[i];
            if (i != 0 && base == nums[i-1]) continue;

            List<List<Integer>> temp = threeSum(Arrays.copyOfRange(nums, i+1, nums.length), target - base);
            if (temp.isEmpty()) continue;
            for(List<Integer> list : temp) {
                List<Integer> t = new LinkedList<>();
                t.add(base);
                t.addAll(list);
                ans.add(t);
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = nums[i];
            if (i != 0 && left == nums[i-1]) continue;
            int low = i + 1, high = nums.length - 1, sum = target - left;
            while (low < high) {
                int cp = Integer.compare(nums[low] + nums[high], sum);
                if (cp == 0) {
                    res.add(Arrays.asList(left, nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low+1]) low++;
                    while (low < high && nums[high-1] == nums[high]) high--;
                    low++;high--;
                } else if (cp < 0) {
                    while (low < high && nums[low] == nums[low+1]) low++;
                    low++;
                } else {
                    while (low < high && nums[high-1] == nums[high]) high--;
                    high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {0,-1,-3,5,-5};
        System.out.println(fourSum.fourSum(nums, 1));
    }
}
