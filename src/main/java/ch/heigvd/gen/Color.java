package ch.heigvd.gen;

public enum Color {
    NONE("no color"),
    BLUE("blue"),
    RED("red"),
    YELLOW("yellow");


    private final String text;

    Color(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
