package com.rbs.support;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Container {
    public Stack<MarketData> listOfMktData=new Stack<>();
    public Container(){
        for(int i=0;i<=20;i++){
            MarketData marketData=new MarketData();
            marketData.initialize();
            listOfMktData.add(marketData);
            System.out.println("market data object created::"+i);
        }

    }
}
