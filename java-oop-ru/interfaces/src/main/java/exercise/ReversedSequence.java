package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    private final String sequence;

    ReversedSequence(String str) {
        sequence = new StringBuilder(str).reverse().toString();
    }

    @Override
    public int length() {
        return sequence.length();
    }

    @Override
    public char charAt(int index) {
        return sequence.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return sequence.subSequence(start, end);
    }

    public String toString() {
        return sequence;
    }
}
// END
