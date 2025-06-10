package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] nums)  {
        Thread firstThread = new MaxThread(nums);
        Thread secondThread = new MinThread(nums);

        firstThread.start();
        LOGGER.info("Thread first started");
        secondThread.start();
        LOGGER.info("Thread second started");

        try {
            firstThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Thread first ended");
        try {
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Thread second ended");
        Map<String, Integer> minMax = new HashMap<>();
        minMax.put("minValue", MinThread.getMinValue());
        minMax.put("maxValue", MaxThread.getMaxValue());
        return minMax;
    }
    // END
}
