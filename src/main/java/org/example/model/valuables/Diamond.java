package org.example.model.valuables;

public class Diamond implements Valuable {

    private final String name;
    private final int value;

    public Diamond() {
        this.name = "Diamond";
        this.value = 50;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }
}
