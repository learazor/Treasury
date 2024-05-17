package org.example.model.valuables;

public class Ruby implements Valuable{

    private final String name;
    private final int value;

    public Ruby() {
        this.name = "Ruby";
        this.value = 10;
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
