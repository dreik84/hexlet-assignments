package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {

    static int minValue;
    int[] nums;

    public MinThread(int[] inputData) {
        this.nums = inputData;
    }

    public static int getMinValue() {
        return minValue;
    }

    @Override
    public void run() {
        if (nums.length > 0) {
            minValue = Arrays.stream(nums).min().getAsInt();
        }
    }
}
// END
