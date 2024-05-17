package org.example.model.actors;

import org.example.RandomNumberGen;
import org.example.logger.LoggerSingleton;
import org.example.model.treasure.Guardsman;
import org.example.model.valuables.Valuable;

import java.util.ArrayList;

public class King implements Runnable, Actor {

    private Guardsman guardsman;
    private Accountant accountant;
    private ArrayList<Valuable> partyFund = new ArrayList<>();

    public King(Guardsman guardsman, Accountant accountant) {
        this.guardsman = guardsman;
        this.accountant = accountant;
    }


    @Override
    public void run() {
        while (true) {
            int valueNeededToThrowParty = RandomNumberGen.getRandomNumberUsingInts(50, 150);
            if (accountant.getCurrentValue() >= valueNeededToThrowParty) {
                int currentPartyFundValue = partyFund.stream().mapToInt(Valuable::getValue).sum();
                while (currentPartyFundValue >= valueNeededToThrowParty) {
                    Valuable valuable = guardsman.getValuable(this);
                    partyFund.add(valuable);
                    currentPartyFundValue = partyFund.stream().mapToInt(Valuable::getValue).sum();
                }
                LoggerSingleton.log("Party is ongoing....");
                partyFund.clear();
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                LoggerSingleton.log("Party has ended....");
            } else {
                LoggerSingleton.log("Party has been canceled. Required: " + valueNeededToThrowParty + ",current treasure value: "+accountant.getCurrentValue()+" there is not enough valuables in the treasure.");
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
