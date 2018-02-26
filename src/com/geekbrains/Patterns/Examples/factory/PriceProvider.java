package com.geekbrains.Patterns.Examples.factory;

public interface PriceProvider {
    Money getPrice(String article);
}
