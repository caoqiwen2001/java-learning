package arrays;

public class Array06 {

    public static void main(String[] args) {
        // System.out.println();
        int[] nums = {5, 8, 7, 8};
        increasingTriplet(nums);
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        if (nums.length < 3) {
            return false;
        }
        for (int num : nums) {
            if (first > num) {
                first = num;
            } else if (first < num && second > num) {
                second = num;
            } else if (num > second) {
                return true;
            }
        }
        return false;
    }

}
