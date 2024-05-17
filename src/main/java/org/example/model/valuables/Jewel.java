package org.example.model.valuables;

public class Jewel implements Valuable {

    private final String name;
    private final int value;

    public Jewel() {
        this.name = "Jewel";
        this.value = 30;
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
