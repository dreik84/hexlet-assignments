package exercise;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage db) {

        db.toMap().forEach((key, value) -> {
            db.unset(key);
            db.set(value, key);
        });
    }
}
// END
