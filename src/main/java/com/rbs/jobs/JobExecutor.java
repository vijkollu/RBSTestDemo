package com.rbs.jobs;

import com.rbs.support.Container;
import com.rbs.support.MarketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class JobExecutor {

    @Autowired
    Container container;

   // @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        while (container.listOfMktData.size()<=20){
            MarketData marketData=new MarketData();
            marketData.initialize();
            container.listOfMktData.add(marketData);
        }
    }
}
