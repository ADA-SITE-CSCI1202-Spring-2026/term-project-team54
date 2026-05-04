package com.team54.airportdispatchtycoonteam54.core.Queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import com.team54.airportdispatchtycoonteam54.core.Planes.Aircraft;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightRequestQueue {

    private final ObservableList<FlightRequest> flightRequestQueue = FXCollections.observableArrayList();

    /**
     * Returns the next Aircraft in the queue without removing it. If the queue is empty, returns null.
     */
    public FlightRequest getNextFlightRequest(){
        return flightRequestQueue.isEmpty() ? null : flightRequestQueue.getFirst();
    }

    /**
     * Removes the next Aircraft from the queue and returns it. If the queue is empty, returns null.
     */
    public FlightRequest clearNextFlightRequest(){
        if (flightRequestQueue.isEmpty()) {
            return null;
        }
        return flightRequestQueue.removeFirst();
    }

    public void addFlightRequest(FlightRequest flightRequest) {
        flightRequestQueue.add(flightRequest);
    }

    /**
     * For use in UI only!!!
     */
    public ObservableList<FlightRequest> getInternalList() {
        return flightRequestQueue;
    }
}
