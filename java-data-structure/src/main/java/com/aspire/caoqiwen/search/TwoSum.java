package com.aspire.caoqiwen.search;

public class TwoSum {

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * <p>
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * <p>
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        twoSum(arr, 9);

    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] == target) {
                arr[0] = left + 1;
                arr[1] = right + 1;
                break;
            }
        }
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            int temp = target - numbers[mid];
//            if (temp < 0) {
//                right = mid - 1;
//            } else {
//                for (int i = 0; i < numbers.length; i++) {
//                    if (numbers[i] == temp) {
//                        if (i > mid) {
//                            arr[1] = i + 1;
//                            arr[0] = mid + 1;
//                        } else if (i < mid) {
//                            arr[0] = i + 1;
//                            arr[1] = mid + 1;
//                        }
//                    }
//                }
//                left = mid + 1;
//            }
//        }


        return arr;
    }
}
