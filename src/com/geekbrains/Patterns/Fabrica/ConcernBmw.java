package com.geekbrains.Patterns.Fabrica;

public class ConcernBmw implements Creator {
    @Override
    public Car factoryMethod() {return new BMW();}
}
