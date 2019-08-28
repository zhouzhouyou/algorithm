package LeetCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int size = height.length;
        int maxarea = 0;
        int right = 0, left = size - 1;
        while (right < left) {
            maxarea = Math.max(maxarea, Math.min(height[right], height[left]) * (left - right));
            if (height[left] < height[right]) left--;
            else right++;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();
        int[] test = {1,8,6,2,5,4,8,3,7};
        //int[] test = {1, 1};
        System.out.println(container.maxArea(test));
    }
}
