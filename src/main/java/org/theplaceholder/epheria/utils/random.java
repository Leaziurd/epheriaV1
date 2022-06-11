package org.theplaceholder.epheria.utils;

import java.util.Random;

public class random {
    public static boolean chance(int i){
        int r = new Random().nextInt(100);
        return r <= i;
    }

    public static int number(int i){

        return new Random().nextInt(i);
    }
}
