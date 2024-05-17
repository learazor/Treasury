package org.example.model.valuables;

public class WoodenCoin implements Valuable{

    private final String name;
    private final int value;

    public WoodenCoin() {
        this.name = "WoodenCoin";
        this.value = 2;
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
