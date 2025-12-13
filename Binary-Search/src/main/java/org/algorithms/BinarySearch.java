package org.algorithms;

public class BinarySearch
{

    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int count = 0;
        while (low <= high) {
            count ++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                System.out.println("The while loop iterated " + count + " times and found " + target);
                return mid;
            }else if (arr[mid] < target) {
                low = mid + 1;
            }else  {
                high = mid - 1;
            }
        }
        System.out.println("The while loop cycled " + count + " times and didnt find the" + target);
        return -1;
    }
}
