package org.example;

import org.example.model.Mine;
import org.example.model.actors.Accountant;
import org.example.model.actors.King;
import org.example.model.actors.ValuableMiner;
import org.example.model.actors.ValuableTransporter;
import org.example.model.treasure.Guardsman;
import org.example.model.treasure.TreasureRoom;
import org.example.model.treasure.Treasury;
import org.example.model.valuables.Valuable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Valuable> deposit = new LinkedBlockingQueue<>(100);
        Mine mine = new Mine("normal");
        ValuableMiner miner = new ValuableMiner(mine, deposit);
        List<Valuable> transporter = Collections.synchronizedList(new ArrayList<>());
        List<Valuable> treasuryVault = Collections.synchronizedList(new ArrayList<>());
        TreasureRoom treasureRoom = new TreasureRoom(treasuryVault);
        Guardsman guardsman = new Guardsman(treasureRoom);
        ValuableTransporter valuableTransporter = new ValuableTransporter(guardsman, transporter, deposit);
        Accountant accountant = new Accountant(guardsman);
        King king = new King(guardsman, accountant);

        new Thread(miner).start();
        new Thread(miner).start();
        new Thread(miner).start();
        new Thread(valuableTransporter).start();
        new Thread(valuableTransporter).start();
        new Thread(accountant).start();
        new Thread(king).start();
    }
}