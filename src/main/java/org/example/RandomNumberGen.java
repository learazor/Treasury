package org.example;

import java.util.Random;

public class RandomNumberGen {

    public static int getRandomNumberUsingInts(int min, int max) {
        return min + new Random().nextInt(max - min);
    }
}
