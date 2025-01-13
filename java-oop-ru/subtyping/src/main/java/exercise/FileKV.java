package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private final String filePath;

    FileKV(String filePath, Map<String, String> dataMap) {
        this.filePath = filePath;
        Utils.writeFile(filePath, Utils.serialize(dataMap));
    }

    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(filePath);
        Map<String, String> dataMap = Utils.deserialize(content);
        dataMap.put(key, value);
        content = Utils.serialize(dataMap);
        Utils.writeFile(filePath, content);
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(filePath);
        Map<String, String> dataMap = Utils.deserialize(content);
        dataMap.remove(key);
        content = Utils.serialize(dataMap);
        Utils.writeFile(filePath, content);
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(filePath);
        Map<String, String> dataMap = Utils.deserialize(content);
        return dataMap.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(filePath);
        return Utils.deserialize(content);
    }
}
// END
