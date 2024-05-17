package org.example.model.treasure;

import org.example.logger.LoggerSingleton;
import org.example.model.actors.Accountant;
import org.example.model.actors.Actor;
import org.example.model.actors.King;
import org.example.model.actors.ValuableTransporter;
import org.example.model.valuables.Valuable;

import java.util.List;

public class Guardsman implements Treasury {

    TreasureRoom treasureRoom;

    public Guardsman(TreasureRoom treasureRoom) {
        this.treasureRoom = treasureRoom;
    }

    @Override
    public void addValuable(Actor actor, List<Valuable> transporter) {
        if (actor instanceof ValuableTransporter) {
            treasureRoom.addValuable(actor, transporter);
        } else {
            LoggerSingleton.log("Only " + ValuableTransporter.class.getName() + " can add new value to the Treasure Room");
        }
    }

    @Override
    public Valuable getValuable(Actor actor) {
        if (actor instanceof King) {
            treasureRoom.getValuable(actor);
        } else {
            LoggerSingleton.log("Only " + King.class.getName() + " can add new value to the Treasure Room");
        }
        return null;
    }

    @Override
    public synchronized int checkValuables(Actor actor) {
        if (actor instanceof Accountant) {
            return treasureRoom.checkValuables(actor);
        } else {
            LoggerSingleton.log("Only " + Accountant.class.getName() + " can add new value to the Treasure Room");
        }
        return 0;
    }
}
