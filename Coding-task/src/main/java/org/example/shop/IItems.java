package org.example.shop;

import java.util.Map;

public interface IItems {
    void addItems(String product, Integer price);
    Map<String, Integer> getItems();
    boolean isValidItems(String product);
}
