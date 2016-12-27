package com.example.brain.mvp_practise.utils;

/**
 * Created by brain on 12/26/16.
 */

public class PreConditions {

    public static <T> T checkNotNull(T reference) {
        if(reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }
}
