package org.example.model.actors;

import org.example.logger.LoggerSingleton;
import org.example.model.treasure.Guardsman;

public class Accountant implements Runnable, Actor {

    private Guardsman guardsman;
    private int currentValue;

    public Accountant(Guardsman guardsman) {
        this.guardsman = guardsman;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
                currentValue = guardsman.checkValuables(this);
                LoggerSingleton.log(String.valueOf(currentValue));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
