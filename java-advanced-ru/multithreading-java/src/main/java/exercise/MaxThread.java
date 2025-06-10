package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {

    static int maxValue;
    private int[] nums;

    public MaxThread(int[] inputData) {
        this.nums = inputData;
    }

    public static int getMaxValue() {
        return maxValue;
    }

    @Override
    public void run() {
        if (nums.length > 0) {
            maxValue = Arrays.stream(nums).max().getAsInt();
        }
    }
}
// END
