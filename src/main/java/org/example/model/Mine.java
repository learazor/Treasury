package org.example.model;

import org.example.model.valuables.Valuable;
import org.example.model.valuables.ValuablesMulti;

public class Mine {
    private String type;

    public Mine(String type) {
        this.type = type;
    }

    public Valuable excavate() {
        return ValuablesMulti.getRandomValuable(0,4);
    }
}
