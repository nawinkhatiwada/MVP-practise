package com.example.brain.mvp_practise;

import com.squareup.otto.Bus;

/**
 * Created by brain on 1/2/17.
 */

public class MVPBus {

    private final Bus bus;
    private static MVPBus mvpBus;

    private MVPBus(){
        this.bus = new Bus();
    }

    public static Bus getInstance(){
        if (mvpBus==null){
            mvpBus = new MVPBus();
        }
        return mvpBus.bus;
    }
}
