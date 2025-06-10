package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

class AppTest {
    @Test
    void testMinMax1() {

        int[] numbers = {10, -4, 67, 100, -100, 8};
        Map<String, Integer> actual = App.getMinMax(numbers);
        Map<String, Integer> expected = Map.of("minValue", -100, "maxValue", 100);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testMinMax2() {

        int[] numbers = {-2, 0};
        Map<String, Integer> actual = App.getMinMax(numbers);
        Map<String, Integer> expected = Map.of("minValue", -2, "maxValue", 0);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testMinMax3() {

        int[] numbers = {0};
        Map<String, Integer> actual = App.getMinMax(numbers);
        Map<String, Integer> expected = Map.of("minValue", 0, "maxValue", 0);
        assertThat(actual).isEqualTo(expected);
    }
}
