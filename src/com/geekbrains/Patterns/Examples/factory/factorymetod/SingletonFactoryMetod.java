package com.geekbrains.Patterns.Examples.factory.factorymetod;

/**
 * Created by i on 21.11.2017.
 */
public class SingletonFactoryMetod {
    private static SingletonFactoryMetod ourInstance = new SingletonFactoryMetod();

    public static SingletonFactoryMetod getInstance() {
        return ourInstance;
    }

    private SingletonFactoryMetod() {
    }

    public FactoryMetod createFactoryMetod() {
        return new FactoryMetodImpl();
    }
}
