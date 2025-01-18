package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();

        return Arrays.stream(fields)
                .filter(field -> checkNotNull(address, field))
                .map(Field::getName)
                .toList();
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        Map<String, List<String>> res = new HashMap<>();

        for (Field field : fields) {

            try {
                field.setAccessible(true);

                if (field.get(address) != null && checkMinLength(address, field)) {
                    var list = new ArrayList<String>();
                    var minLen = field.getAnnotation(MinLength.class).minLength();
                    list.add(String.format("%s=[length less than %d]", field.getName(), minLen));
                    res.put(field.getName(), list);
                }
                if (checkNotNull(address, field)) {
                    var list = res.getOrDefault(field.getName(), new ArrayList<>());
                    list.add(String.format("%s=[can not be null]", field.getName()));
                    res.put(field.getName(), list);
                }
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }

        return res;
    }

    private static boolean checkNotNull(Address address, Field field) {
        try {
            field.setAccessible(true);

            return field.get(address) == null && field.getAnnotation(NotNull.class) != null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean checkMinLength(Address address, Field field) {
        try {
            field.setAccessible(true);
            var annotation = field.getAnnotation(MinLength.class);
            var valueLength = field.get(address).toString().length();

            return annotation != null && valueLength < annotation.minLength();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
