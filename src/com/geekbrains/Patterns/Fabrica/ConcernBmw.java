package com.geekbrains.Patterns.Fabrica;

public class ConcernBmw extends Creator {
    @Override
    public Car factoryMethod() {return new BMW();}
}
