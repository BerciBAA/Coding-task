package org.example.shop;

import java.util.HashMap;
import java.util.Map;

public class Items implements IItems{

    private final Map<String, Integer> items;

    public Items(){
        items = new HashMap<>();
        initItems();
    }

    private void initItems(){
        items.put("A",55);
        items.put("B",20);
        items.put("C",60);
        items.put("D",10);
        items.put("E",45);
    }

    public void addItems(String product, Integer price){
        if (!isItInTheList(product))
            items.put(product,price);
    }

    public Map<String, Integer> getItems(){
        return items;
    }

    private boolean isItInTheList(String product){
        return items.containsKey(product);
    }

    public boolean isValidItems(String product){
        return items.containsKey(product);
    }
}
