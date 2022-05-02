package com.oop.BargainBin.observerPattern;

import com.oop.BargainBin.models.ProductModel;

/**
 * The publisher subject interface
 * @author Athul
 */
public interface PublisherSubject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyUpdate(ProductModel model);
}
