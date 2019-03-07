package com.wiley.javainterviewsexposed.chapter17;

public class Ticket {

    private int id;
    private Event event;

    public Ticket() {
    }

    public Ticket(int id, Event event) {
        this.id = id;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", event=" + event +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
