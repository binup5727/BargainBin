package com.oop.BargainBin.observerPattern;

import com.oop.BargainBin.models.ProductModel;

/**
 * Observer interface
 */
public interface Observer {
    void update(ProductModel model);
}
