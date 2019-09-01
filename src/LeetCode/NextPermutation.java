package LeetCode;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i+1] <= nums[i]) i--;

        if (i < 0) {
            reverse(nums, 0);
            return;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) j--;
        swap(nums, i, j);
        reverse(nums, i+1);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;right--;
        }
    }
}
