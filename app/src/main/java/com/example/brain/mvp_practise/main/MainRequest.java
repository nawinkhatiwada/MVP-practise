package com.example.brain.mvp_practise.main;

/**
 * Created by nawin on 12/29/16.
 */

public interface MainRequest {
    int typeDashboard = 1;
    int typeMessage = 2;

    int getType();
}
