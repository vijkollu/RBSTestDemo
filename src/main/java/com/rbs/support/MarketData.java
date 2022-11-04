package com.rbs.support;

public class MarketData{

    public int index;

    public void initialize(){
        //System.out.println("market data initialized::");

    }
    public void process(){
        try {
            System.out.println(Thread.currentThread().getName()+":::"+"Stated sleep");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName()+":::"+"Endd sleep");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }}
