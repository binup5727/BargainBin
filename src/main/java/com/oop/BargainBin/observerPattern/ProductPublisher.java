package com.oop.BargainBin.observerPattern;

import com.oop.BargainBin.models.ProductModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Publisher for product in the observer pattern
 */
public class ProductPublisher implements PublisherSubject {
    private List<Observer> observers = new ArrayList<>();

    /**
     * Attaching the observer
     * @param o observer passed
     */
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    /**
     * Detaching the observer
     * @param o observer passed
     */
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    /**
     * Notifying the observer with the product
     * @param model product
     */
    @Override
    public void notifyUpdate(ProductModel model) {
        for(Observer o: observers) {
            o.update(model);
        }
    }
}
