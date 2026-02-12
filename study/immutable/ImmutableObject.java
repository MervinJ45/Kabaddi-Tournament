package study.immutable;

public final class ImmutableObject {
    private final int id;
    private final String name;

    ImmutableObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        ImmutableObject imObj = new ImmutableObject(1, "Rohit");
    }
}
