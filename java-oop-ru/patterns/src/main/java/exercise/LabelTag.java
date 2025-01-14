package exercise;

// BEGIN
public class LabelTag implements TagInterface {

    private final String value;
    private final TagInterface child;

    LabelTag(String value, TagInterface child) {
        this.value = value;
        this.child = child;
    }

    @Override
    public String render() {
        return "<label>" + value + child.render() + "</label>";
    }
}
// END
