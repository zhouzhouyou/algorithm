package LeetCode;

public class SearchInRotateSortedArray {
    /*
    https://leetcode.com/problems/search-in-rotated-sorted-array/
     */

    public int search(int[] nums, int target) {
        int length = nums.length;
        int low = 0, high = length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[low]) {
                //left part is ordered
                //如果target在左侧，那么最高值小于mid，high减小到mid左侧
                //否则，low增大到mid右侧
                if (target >= nums[low] && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                //right part is ordered
                if (target > nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;

    }


}
