package com.maitianer.common.utils;

import java.util.Random;

/**
 * @Author yuzhe
 * @Date 2018/12/7 21:41
 **/
public class RandomUtils {

    public static String rand5Num() {
        return String.valueOf((int) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000);
    }

    public static String rand4Num() {
        return String.valueOf((int) (new Random().nextDouble() * (9999 - 1000 + 1)) + 1000);
    }
}
