package org.example.model.treasure;

import org.example.model.actors.Actor;
import org.example.model.valuables.Valuable;

import java.util.List;

public class TreasureRoom implements Treasury {

    private List<Valuable> valuables;

    public TreasureRoom(List<Valuable> valuables) {
        this.valuables = valuables;
    }

    @Override
    public void addValuable(Actor actor, List<Valuable> transporter) {
        valuables.addAll(transporter);
    }

    @Override
    public Valuable getValuable(Actor actor) {
        return valuables.stream().findAny().orElseThrow();
    }

    @Override
    public synchronized int checkValuables(Actor actor) {
        return valuables.stream().mapToInt(Valuable::getValue).sum();
    }
}
