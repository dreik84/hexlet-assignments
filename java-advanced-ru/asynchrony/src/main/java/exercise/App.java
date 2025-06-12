package exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String firstPath, String secondPath, String resultPath) {

        CompletableFuture<String> getFirstFileData = CompletableFuture.supplyAsync(() -> {
            try {
                Path normalizedPath = Path.of(firstPath);
                return Files.readAllLines(normalizedPath).toString();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return ex.getMessage();
        });

        CompletableFuture<String> getSecondFileData = CompletableFuture.supplyAsync(() -> {
            Path normalizedPath = Paths.get(secondPath);
            try {
                return Files.readString(normalizedPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return ex.getMessage();
        });

        return getFirstFileData.thenCombine(getSecondFileData,
                (firstData, secondData) -> {
                    String result = firstData + secondData;
                    Path resultingPath = Path.of(resultPath);
                    try {
                        Files.writeString(resultingPath, result);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return result;
                }).exceptionally(Throwable::getMessage);
    };
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        unionFiles(
    "src/main/resources/file1.txt",
    "src/main/resources/file2.txt",
    "src/main/resources/dest.txt"
        );
        // END
    }
}
