package org.example.shop;

import java.util.Map;

public class PricingRules implements IPricingRules{

    private final IShoppingCart shoppingCart;

    private final IItems items;

    public PricingRules(IShoppingCart shoppingCart, IItems items){

        this.shoppingCart = shoppingCart;
        this.items = items;
    }

    public Integer calculatePrice(){

        int totalPrice = 0;
        Map<String, Integer> cartItems = shoppingCart.getCart();
        Map<String, Integer> itemsItems = items.getItems();

        for(Map.Entry<String, Integer> entry : cartItems.entrySet()){
            totalPrice += itemsItems.get(entry.getKey()) * entry.getValue();
        }

        int deductedPrice1 = ruleOne(cartItems, itemsItems, totalPrice);
        int deductedPrice2 = ruleTwo(cartItems, itemsItems);
        int finalPrice = totalPrice - deductedPrice1 - deductedPrice2;
        int specialTax = ruleThree(cartItems, finalPrice);

        return finalPrice - specialTax ;
    }

    private Integer ruleOne(Map<String, Integer> cartItems, Map<String, Integer> itemsItems ,int totalPrice){
        int totalPriceCopy = totalPrice;
        if(cartItems.getOrDefault("A",0) >= 2 && cartItems.getOrDefault("C",0) >= 1)
            totalPrice -= itemsItems.get("C") / 2;
        return totalPriceCopy - totalPrice;
    }

    private Integer ruleTwo( Map<String, Integer> cartItems, Map<String, Integer> itemsItems){
        int numberOfDiscountedItems = 0;
        if(cartItems.getOrDefault("D",0) != 0)
            numberOfDiscountedItems = cartItems.get("D") / 3;
        return itemsItems.getOrDefault("D",0) * numberOfDiscountedItems;
    }

    private Integer ruleThree(Map<String, Integer> cartItems, int totalPrice){
        int totalPriceCopy = totalPrice;
        if(cartItems.getOrDefault("D",0) >= 1 && cartItems.getOrDefault("E",0) >= 1)
            totalPrice *= 1.3;
        return totalPriceCopy - totalPrice;
    }


}
