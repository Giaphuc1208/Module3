package org.example.product_discount_calculator.service;

public interface IDiscountService {
    double discountAmount(double list_price, double discount_price);
    double discountAmountAfter(double discount_amount, double list_price);
}
