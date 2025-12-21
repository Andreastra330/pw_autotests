package com.myshowsME.Utils;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;


public class CommonUtils {

    public static String randomString(int size){
        return RandomStringUtils.randomAlphabetic(size);
    }


    public static String randomEmail(int sizeEmail, int sizeDomain){
        return "%s@%s.ru".formatted(randomString(sizeEmail),randomString(sizeDomain));
    }

//    public static String myTry(int size){
//        return Random.from(String).toString()
//    }
}
