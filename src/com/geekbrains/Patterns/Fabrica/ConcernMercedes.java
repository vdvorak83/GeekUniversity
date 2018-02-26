package com.geekbrains.Patterns.Fabrica;

public class ConcernMercedes extends Creator {
    @Override
    public Car factoryMethod() {
        return new Mercedes();
    }
}
