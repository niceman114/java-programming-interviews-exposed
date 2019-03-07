package com.wiley.javainterviewsexposed.chapter17;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {

    private int id;
    private int venueId;
    private String eventName;
    private Date eventDate;

    public static AtomicInteger constructedInstances =
                                                  new AtomicInteger(0);

    public Event() {
        constructedInstances.getAndIncrement();
    }

    public Event(int id, int venueId, String eventName, Date eventDate) {
        this.id = id;
        this.venueId = venueId;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (venueId != event.venueId) return false;
        if (eventDate != null ? !eventDate.equals(event.eventDate) : event.eventDate != null) return false;
        if (eventName != null ? !eventName.equals(event.eventName) : event.eventName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + venueId;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", venueId=" + venueId +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}
