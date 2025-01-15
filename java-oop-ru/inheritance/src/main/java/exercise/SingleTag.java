package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    SingleTag(String name, Map<String, String> attrs) {
        super(name, attrs);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append(String.format("<%s", name));
        attrs.forEach((attr, value) -> res.append(String.format(" %s=\"%s\"", attr, value)));
        res.append(">");

        return res.toString();
    }
}
// END
