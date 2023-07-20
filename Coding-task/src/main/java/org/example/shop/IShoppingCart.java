package org.example.shop;

import java.util.Map;

public interface IShoppingCart {
    void addItem(String product);
    Map<String, Integer> getCart();
}
