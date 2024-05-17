package org.example.model.actors;

import org.example.logger.LoggerSingleton;
import org.example.model.Mine;
import org.example.model.valuables.Valuable;

import java.util.concurrent.BlockingQueue;

public class ValuableMiner implements Runnable, Actor {

    private Mine mine;
    private BlockingQueue<Valuable> deposit;
    private LoggerSingleton loggerSingleton = LoggerSingleton.getInstance(ValuableMiner.class.getName());

    public ValuableMiner(Mine mine, BlockingQueue<Valuable> deposit) {
        this.mine = mine;
        this.deposit = deposit;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
                Valuable valuable = mine.excavate();
                deposit.put(valuable);
                LoggerSingleton.log("Valuable: "+ valuable.getName()+ " of value: "+valuable.getValue()+" has been deposited.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public BlockingQueue<Valuable> getDeposit() {
        return deposit;
    }
}
