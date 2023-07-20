package org.example;

import org.example.shop.*;

public class Main {
    public static void main(String[] args) {

        IItems items = new Items();
        IShoppingCart shoppingCart = new ShoppingCart(items);

        for(String rawLetter : args){
            String item = rawLetter.replaceAll("[\\[\\],\\“\\”]","");
            shoppingCart.addItem(item);
        }

        PricingRules pricingRules = new PricingRules(shoppingCart, items);

        int totalPrice = pricingRules.calculatePrice();

        System.out.println("Total price: " + totalPrice);
    }
}