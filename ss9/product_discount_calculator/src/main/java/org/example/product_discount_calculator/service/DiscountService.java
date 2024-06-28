package org.example.product_discount_calculator.service;

public class DiscountService implements IDiscountService {

    @Override
    public double discountAmount(double list_price, double discount_price) {
        double discount_amount;
        return discount_amount = list_price * discount_price * 0.01;
    }

    @Override
    public double discountAmountAfter(double discount_amount, double list_price) {
        double discount_price;
        return discount_price = list_price - discount_amount;
    }
}
