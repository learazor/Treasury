package org.example.model.actors;

import org.example.logger.LoggerSingleton;
import org.example.RandomNumberGen;
import org.example.model.treasure.Guardsman;
import org.example.model.treasure.TreasureRoom;
import org.example.model.valuables.Valuable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ValuableTransporter implements Runnable, Actor {

    private List<Valuable> transporter;
    private BlockingQueue<Valuable> deposit;
    private Guardsman guardsman;

    public ValuableTransporter(Guardsman guardsman, List<Valuable> transporter, BlockingQueue<Valuable> deposit) {
        this.transporter = transporter;
        this.deposit = deposit;
        this.guardsman = guardsman;
    }

    @Override
    public void run() {
        while (true){
            int maxValue = RandomNumberGen.getRandomNumberUsingInts(50, 200);
            int sum = deposit.stream().mapToInt(Valuable::getValue).sum();
            if (sum >= maxValue) {
                transporter = new ArrayList<>(deposit);
                deposit.clear();
                try {
                    LoggerSingleton.log(ValuableTransporter.class.getName()+" Deposit value sum is: "+sum+" - Transporting from deposit to the treasury, started...");
                    Thread.sleep(30000);
                    guardsman.addValuable(this, transporter);
                    LoggerSingleton.log(ValuableTransporter.class.getName()+"- Transporting from deposit to the treasury, ended.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
