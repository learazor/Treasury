package org.example.model.valuables;

import com.google.common.collect.ArrayListMultimap;
import org.example.RandomNumberGen;

import static org.example.model.valuables.ValuableName.*;

public class ValuablesMulti {

    private static final ArrayListMultimap<String, Valuable> valuables;

    static {
        valuables = ArrayListMultimap.create();
        valuables.put(Diamond.name(), new Diamond());
        valuables.put(Jewel.name(), new Jewel());
        valuables.put(GoldNugget.name(), new GoldNugget());
        valuables.put(Ruby.name(), new Ruby());
        valuables.put(WoodenCoin.name(), new WoodenCoin());
    }

    public static Valuable getValuableByName(String name) {
        return valuables.get(name).stream().findAny().orElseThrow();
    }

    public static Valuable getRandomValuable(int min, int max) {
        return valuables.entries().stream().toList()
                .get(RandomNumberGen.getRandomNumberUsingInts(min, max)).getValue();

    }

}
