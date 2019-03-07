package com.wiley.javainterviewsexposed.chapter11.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.Date;

public class MessageActor extends UntypedActor {

    @Override
    public void onReceive(Object message) {
        if (message instanceof Message) {
            Message m = (Message) message;
            System.out.printf("Message [%s] received at %s%n",
                    m.getMessage(),
                    new Date().toString());
        }
    }

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("actorSystem");
        final ActorRef actorRef = system.actorOf(
                Props.create(MessageActor.class),
                "messageProcessor");

        actorRef.tell(new Message("Hello actor system"), null);
    }
}