package com.wiley.javainterviewsexposed.chapter11.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinRouter;

public class MultiActors {

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("actorSystem");
        final ActorRef ref = system
                .actorOf(Props.create(LongRunningActor.class)
                .withRouter(new RoundRobinRouter(3)));

        System.out.println("Sending m1");
        ref.tell("Message 1", null);
        System.out.println("Sending m2");
        ref.tell("Message 2", null);
        System.out.println("Sending m3");
        ref.tell("Message 3", null);
    }

}

class LongRunningActor extends UntypedActor {
    @Override
    public void onReceive(Object message) {
        System.out.printf("Being run on ActorRef: %s%n", getSelf());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Received %s%n", message);
    }
}
