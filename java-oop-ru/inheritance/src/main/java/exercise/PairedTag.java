package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {

    protected String content;
    protected List<Tag> children;

    PairedTag(String name, Map<String, String> attrs, String content, List<Tag> children) {
        super(name, attrs);
        this.content = content;
        this.children = children;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append(String.format("<%s", name));
        attrs.forEach((attr, value) -> res.append(String.format(" %s=\"%s\"", attr, value)));
        res.append(">");
        res.append(content);
        children.forEach(child -> res.append(child.toString()));
        res.append(String.format("</%s>", name));

        return res.toString();
    }
}
// END
