package org.example.model.treasure;

import org.example.model.actors.Actor;
import org.example.model.valuables.Valuable;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface Treasury {

    void addValuable(Actor actor, List<Valuable> transporter);
    Valuable getValuable(Actor actor);
    int checkValuables(Actor actor);
}
