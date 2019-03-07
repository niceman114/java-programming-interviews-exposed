package com.wiley.javainterviewsexposed.chapter11.actors;

import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

public class DividingActor extends UntypedActor {
    @Override
    public void onReceive(Object message) {
        if(message instanceof Integer) {
            Integer number = (Integer) message;
            int result = 10 / number;
            this.getSender().tell(result, getSelf());
        }
    }

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return new OneForOneStrategy(
            10,
            Duration.Inf(),
            new Function<Throwable, SupervisorStrategy.Directive>() {
                @Override
                public SupervisorStrategy.Directive apply(Throwable t) {
                    return SupervisorStrategy.restart();
                }
        });
    }
}
