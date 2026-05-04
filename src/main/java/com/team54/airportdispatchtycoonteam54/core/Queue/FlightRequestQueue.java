package com.team54.airportdispatchtycoonteam54.core.Queue;

import java.io.*;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightRequestQueue extends AbstractQueue<FlightRequest> implements Serializable {

    // the maximum number of flight requests that can be in the queue at a time;
    private final static int maxSize = 10;

    // transient so Serializer ignores it
    private transient ObservableList<FlightRequest> flightRequestQueue = FXCollections.observableArrayList();

    /**
     * For use in UI only!!!
     * Returns a read only version of the FlightRequest queue.
     */
    public ObservableList<FlightRequest> getInternalList() {
        return FXCollections.unmodifiableObservableList(flightRequestQueue);
    }

    @Override
    public boolean offer(FlightRequest e) {
        if (e == null) return false;
        if(flightRequestQueue.size() >= maxSize) return false;
        return flightRequestQueue.add(e);
    }

    @Override
    public FlightRequest poll() {
        if (flightRequestQueue.isEmpty()) return null;
        return flightRequestQueue.removeFirst();
    }

    @Override
    public FlightRequest peek() {
        return flightRequestQueue.isEmpty() ? null : flightRequestQueue.getFirst();
    }

    @Override
    public Iterator<FlightRequest> iterator() {
        return flightRequestQueue.iterator();
    }

    @Override
    public int size() {
        return flightRequestQueue.size();
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(new ArrayList<>(flightRequestQueue));
    }

    @Serial
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        in.defaultReadObject();

        List<FlightRequest> list = (List<FlightRequest>) in.readObject();

        flightRequestQueue = FXCollections.observableArrayList(list);
    }
}
