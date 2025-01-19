package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path filePath, Car car) {
        Path fullPath = Paths.get(filePath.toString()).toAbsolutePath().normalize();
        String content = car.serialize();
        try {
            Files.writeString(fullPath, content, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Car extract(Path filePath) {
        Path fullPath = Paths.get(filePath.toString()).toAbsolutePath().normalize();
        String content = "";
        try {
            content = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Car.deserialize(content);
    }
}
// END
