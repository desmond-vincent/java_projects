package org.algorithms;

public record TwoSum(int[] arr, int target) {
    public TwoSum(int[] arr, int target) {
        this.arr = arr;
        this.target = target;
        IO.println(sumTwo(arr, target));
    }

    private static String sumTwo(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return "Position: " + left + "," + right + " | Value: " + arr[left] + "," + arr[right] + " | Target: " + target;
            }
        }
        return "Target not met";
    }
}
