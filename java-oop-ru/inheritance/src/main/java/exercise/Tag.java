package exercise;

import java.util.Map;

// BEGIN
public abstract class Tag {
    protected  String name;
    protected Map<String, String> attrs;

    Tag(String name, Map<String, String> attrs) {
        this.name = name;
        this.attrs = attrs;
    }

    public abstract String toString();
}
// END
