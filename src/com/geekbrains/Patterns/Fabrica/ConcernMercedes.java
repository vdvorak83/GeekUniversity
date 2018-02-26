package com.geekbrains.Patterns.Fabrica;

public class ConcernMercedes implements Creator {
    @Override
    public Car factoryMethod() {
        return new Mercedes();
    }
}
