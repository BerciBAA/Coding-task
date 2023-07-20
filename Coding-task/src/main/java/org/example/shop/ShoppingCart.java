package org.example.shop;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements IShoppingCart{

    private final IItems items;
    private final Map<String, Integer> Cart;

    public ShoppingCart(IItems items) {

        this.items = items;
        Cart = new HashMap<>();
    }

    public void addItem(String product){
        if (items.isValidItems(product))
            Cart.put(product, Cart.getOrDefault(product,0) + 1);
    }

    public Map<String, Integer> getCart(){
        return Cart;
    }
}
