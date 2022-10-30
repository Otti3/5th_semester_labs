public class Symbol {
    private final Character value;//Character, not char, coz hasn't methods(toString, etc.)

    public Symbol(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}