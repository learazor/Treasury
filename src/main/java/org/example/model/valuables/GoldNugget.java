package org.example.model.valuables;

public class GoldNugget implements Valuable{

    private final String name;
    private final int value;

    public GoldNugget() {
        this.name = "GoldNugget";
        this.value = 25;
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
