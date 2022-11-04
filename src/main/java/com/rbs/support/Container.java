package com.rbs.support;

import java.util.Stack;


public class Container {
    public Stack<MarketData> listOfMktData=new Stack<>();
    public Container(){
        for(int i=0;i<=4;i++){
            MarketData marketData=new MarketData();
            marketData.index=i;
            marketData.initialize();
            listOfMktData.add(marketData);
            System.out.println("market data object created::"+i);
        }

    }
    public MarketData takeOut(){
        while(listOfMktData.isEmpty()){
            try {
                System.out.println("Thread is going sleep for 10seconds:::");
                Thread.sleep(10000);
                System.out.println("Thread completed sleep for 10seconds:::");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return  listOfMktData.pop();
    }

    public void takeIn(MarketData marketData){
        listOfMktData.push(marketData);
    }
}
